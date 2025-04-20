package com.example.data.remote

import com.example.data.model.CommonResponse
import com.example.data.model.UserDto
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSourceImpl @Inject constructor(private val apiService: APIService) {
    suspend fun loginUser(): Response<CommonResponse<UserDto>> {
        return apiService.loginUser()
    }
}