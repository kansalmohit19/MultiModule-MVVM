package com.example.data.remote

import com.example.data.model.CommonResponse
import com.example.data.model.UserDto
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Response

@Singleton
class DataSourceImpl @Inject constructor(private val apiService: APIService) {
    suspend fun loginUser(): Response<CommonResponse<UserDto>> {
        return apiService.loginUser()
    }
}
