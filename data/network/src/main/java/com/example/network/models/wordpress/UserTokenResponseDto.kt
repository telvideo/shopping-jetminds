package com.example.network.models.wordpress

import com.google.gson.annotations.SerializedName

data class UserTokenResponseDto(
    @SerializedName("token_type")
    val tokenType: String?,
    val iat: Int?,
    @SerializedName("expires_in")
    val expiresIn: Int?,
    @SerializedName("jwt_token")
    val jwtToken: String?
)