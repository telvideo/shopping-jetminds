package com.example.domain.models

data class ProductsResponse(
    val id: Int?,
    val name: String?,
    val slug: String?,
    val dateCreated: String?,
    val type: String?,
    val status: String?,
    val featured: Boolean?,
    val catalogVisibility: String?,
    val description: String?,
    val shortDescription: String?,
    val sku: String?,
    val price: String?,
    val regularPrice: String?,
    val salePrice: String?,
    val dateOnSaleFrom: String?,
    val dateOnSaleTo: String?,
    val onSale: Boolean?,
    val purchasable: Boolean?,
    val totalSales: Int?,
    val taxStatus: String?,
    val taxClass: String?,
    val manageStock: Boolean?,
    val stockQuantity: Int?,
    val soldIndividually: Boolean?,
    val shippingRequired: Boolean?,
    val shippingTaxable: Boolean?,
    val shippingClass: String?,
    val shippingClassId: Int?,
    val reviewsAllowed: Boolean?,
    val averageRating: String?,
    val ratingCount: Int?,
    val categories: List<Category>?,
    val tags: List<Tag>?,
    val images: List<Image>?,
    val attributes: List<Attribute>?,
    val defaultAttributes: List<DefaultAttribute>?,
    val stockStatus: String?,
    val isFavorite: Boolean?,
    val downloaded: Boolean?
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$name",
            "${name?.first()}"
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}