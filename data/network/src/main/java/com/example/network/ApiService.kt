package com.example.network

import com.example.network.models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Products -----------------------------------------------------------------------
    @GET("products")
    suspend fun getProducts(): List<ProductsResponseDto>

    @GET("products/{id}")
    suspend fun getProductDetails(
        @Path("id") productId: Int
    ): ProductsResponseDto

    @GET("products/{product_id}/variations/")
    suspend fun getProductVariations(
        @Path("product_id") productId: Int
    ): List<ProductVariationsResponseDto>

    @GET("products/{product_id}/variations/{id}")
    suspend fun getProductVariationDetails(
        @Path("product_id") productId: Int,
        @Path("id") variationId: Int
    ): ProductVariationsResponseDto

    @GET("products/attributes")
    suspend fun getProductAttributes(): List<ProductAttributesResponseDto>

    @GET("products/attributes/{id}")
    suspend fun getProductAttributeDetails(
        @Path("id") attrId: Int
    ): ProductAttributesResponseDto

    @GET("products/categories")
    suspend fun getProductCategories(): List<ProductCategoriesResponseDto>

    @GET("products/categories/{id}")
    suspend fun getProductCategoryDetails(
        @Path("id") categoryId: Int
    ): ProductCategoriesResponseDto

    @GET("products/shipping_classes/")
    suspend fun getProductShippingClasses(): List<ProductShippingClassesResponseDto>

    @GET("products/tags")
    suspend fun getProductTags(
        @Query("page") page: Int = 1
    ): List<ProductTagsResponseDto>

    @GET("products/tags/{id}")
    suspend fun getProductTagDetails(
        @Path("id") tagId: Int
    ): ProductTagsResponseDto

    @GET("products/reviews")
    suspend fun getProductReviews(): List<ProductReviewsResponseDto>

    @GET("products/reviews/{id}")
    suspend fun getProductReviewDetails(
        @Path("id") reviewId: Int
    ): ProductReviewsResponseDto

    // Orders -------------------------------------------------------------------------
    @GET("orders")
    suspend fun getOrders(
        @Query("page") page: Int = 1
    ): List<OrdersResponseDto>

    @GET("orders/{id}")
    suspend fun getOrderDetails(
        @Path("id") orderId: Int
    ): OrdersResponseDto

    // Shipping Zones -----------------------------------------------------------------
    @GET("shipping/zones")
    suspend fun getShippingZones(): List<ShippingZonesResponseDto>

    // Customers ---------------------------------------------------------------------
    @GET("customers/{id}")
    suspend fun getCustomerDetails(
        @Path("id") customerId: Int
    ): CustomersResponseDto

    // Coupons ----------------------------------------------------------------------
    @GET("coupons")
    suspend fun getCoupons(
        @Query("page") page: Int = 1
    ): List<CouponsResponseDto>

    @GET("coupons/{id}")
    suspend fun getCouponDetails(
        @Path("id") couponId: Int
    ): CouponsResponseDto
}