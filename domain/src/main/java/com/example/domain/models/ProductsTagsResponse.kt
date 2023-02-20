package com.example.domain.models

data class ProductsTagsResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val description: String,
    val count: Int
)