/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 1:28 AM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart.GetCartTotalCountsUseCase
import com.example.domain.use_cases.product_categories.GetProductCategoriesUseCase
import com.example.domain.use_cases.product_categories.GetProductCategoryDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class ProductCategoriesViewModel @Inject constructor(
    private val getProductCategoriesUseCase: GetProductCategoriesUseCase,
    private val getProductCategoryDetailsUseCase: GetProductCategoryDetailsUseCase,
    private val getCartTotalCountsUseCase: GetCartTotalCountsUseCase
): ViewModel() {

    private var _categoriesState = MutableStateFlow(MainProductCategoriesUiState(ProductCategoriesUiState.Loading))
    val categoriesState = _categoriesState.asStateFlow()

    private var _categoryDetailsState = MutableStateFlow(MainProductCategoryDetailsUiState(ProductCategoryDetailsUiState.Loading))
    val categoryDetailsState = _categoryDetailsState.asStateFlow()

    private val _cartTotalCountState = MutableStateFlow(0)
    val cartTotalCountState = _cartTotalCountState.asStateFlow()

    init {
        getCategories()
        getCartTotalCount()
    }

    private fun getCategories() {
        viewModelScope.launch {
           getProductCategoriesUseCase.invoke().collect { categoriesResult ->
                val categoriesUiStateResult = when (categoriesResult) {
                    ServiceResult.Loading -> ProductCategoriesUiState.Loading
                    is ServiceResult.Success -> ProductCategoriesUiState.Success(categories = categoriesResult.data)
                    is ServiceResult.Error -> ProductCategoriesUiState.Error(message = categoriesResult.throwable?.message!!)
                }

               _categoriesState.value = MainProductCategoriesUiState(categoriesUiStateResult)
            }
        }
    }

    fun getCategoryDetails(categoryId: Int) {
        viewModelScope.launch {
            getProductCategoryDetailsUseCase.invoke(categoryId = categoryId).collect { categoryDetailsResult ->
                val categoryDetailsUiStateResult = when (categoryDetailsResult) {
                    ServiceResult.Loading -> ProductCategoryDetailsUiState.Loading
                    is ServiceResult.Success -> ProductCategoryDetailsUiState.Success(
                        categoryDetails = categoryDetailsResult.data
                    )
                    is ServiceResult.Error -> ProductCategoryDetailsUiState.Error(
                        message = categoryDetailsResult.throwable?.message!!
                    )
                }
                _categoryDetailsState.value = MainProductCategoryDetailsUiState(
                    categoryDetailsUiState = categoryDetailsUiStateResult
                )
            }
        }
    }

    private fun getCartTotalCount() {
        viewModelScope.launch {
            getCartTotalCountsUseCase.invoke().collect {
                _cartTotalCountState.value = it!!
            }
        }
    }
}