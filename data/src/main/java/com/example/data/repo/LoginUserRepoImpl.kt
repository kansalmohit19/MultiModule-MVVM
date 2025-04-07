package com.example.data.repo

import com.example.core.Either
import com.example.core.IFailure
import com.example.domain.model.User
import com.example.domain.repo.LoginUserRepo
import javax.inject.Inject

class LoginUserRepoImpl @Inject constructor() : LoginUserRepo {
    override fun loginUser(): Either<User, IFailure> {
        return Either.Success(User("", "", ""))
    }
}