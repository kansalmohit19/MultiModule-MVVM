package com.example.data.remote

import com.example.data.model.CommonResponse
import com.example.data.model.UserDto
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("login.txt")
    suspend fun loginUser(): Response<CommonResponse<UserDto>>
}
