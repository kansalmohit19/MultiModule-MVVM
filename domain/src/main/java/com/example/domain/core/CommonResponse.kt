package com.example.domain.core

import com.google.gson.annotations.SerializedName

data class CommonResponse<T>(
    @SerializedName("message") val message: String,
    @SerializedName("status") val statusCode: Int,
    @SerializedName("data") val data: T
)
