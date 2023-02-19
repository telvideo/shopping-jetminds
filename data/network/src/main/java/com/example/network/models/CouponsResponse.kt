package com.example.network.models

data class CouponsResponse(
    val id: Int,
    val code: String,
    val amount: String,
    val status: String,
    val date_created: String,
    val date_created_gmt: String,
    val date_modified: String,
    val date_modified_gmt: String,
    val discount_type: String,
    val description: String,
    val date_expires: String,
    val date_expires_gmt: String,
    val usage_count: Int,
    val individual_use: Boolean,
    val product_ids: List<Int>,
    val excluded_product_ids: List<Int>,
    val usage_limit: Int,
    val usage_limit_per_user: Int,
    val limit_usage_to_x_items: Int,
    val free_shipping: Boolean,
    val product_categories: List<Category>,
    val exclude_sale_items: Boolean,
    val maximum_amount: String,
    val minimum_amount: String,
    val email_restrictions: List<String>
)