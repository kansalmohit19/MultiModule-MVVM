package com.example.data.model

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("country_code") val countryCode: String,
    @SerializedName("phone_no") val phoneNo: String
)
