package com.example.domain.usecase.auth

interface LoginUserUseCase {
    suspend operator fun invoke(loginRequest: LoginRequest)
}