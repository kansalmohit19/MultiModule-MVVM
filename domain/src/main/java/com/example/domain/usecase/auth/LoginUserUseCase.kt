package com.example.domain.usecase.auth

import com.example.domain.core.Either
import com.example.domain.core.IFailure
import com.example.domain.core.UseCase
import com.example.domain.model.User
import com.example.domain.repo.LoginUserRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUserUseCase @Inject constructor(private val loginUserRepo: LoginUserRepo) :
    UseCase<LoginRequest, User>() {

    override suspend fun run(params: LoginRequest): Either<User, IFailure> {
        return loginUserRepo.loginUser()
    }
}
