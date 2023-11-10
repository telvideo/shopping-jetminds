package com.example.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.utils.WhileUiSubscribed
import com.example.domain.models.ProductsResponse
import com.example.domain.use_cases.products.GetProductsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _productsUiState = MutableStateFlow(MainProductsUiState(ProductsUiState.Loading))
    val productsUiState = _productsUiState.asStateFlow()

    private val _products = MutableStateFlow(emptyList<ProductsResponse>())
    val products = searchText
        .debounce(1000)
        .onEach { _isSearching.update { true } }
        .combine(_products) { text, products ->
            if (text.isEmpty() || text.isBlank()) {
                products
            } else {
                delay(1000)
                products.filter { productsResponse ->
                    productsResponse.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            scope = viewModelScope,
            started = WhileUiSubscribed,
            initialValue = _products.value
        )

    init {
        getProducts()
    }

    fun addProducts(products: List<ProductsResponse>) {
        _products.value = products
    }

    private fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase.invoke().collect { productsResult ->
                val productsUiStateResult = when (productsResult) {
                    ServiceResult.Loading -> ProductsUiState.Loading
                    is ServiceResult.Success -> ProductsUiState.Success(
                        products = productsResult.data
                    )
                    is ServiceResult.Error -> ProductsUiState.Error(
                        throwable = productsResult.throwable!!
                    )
                }
                _productsUiState.value = MainProductsUiState(
                    response = productsUiStateResult
                )
            }
        }
    }

    fun onSearchTextChanged(text: String) {
        _searchText.value = text
    }
}