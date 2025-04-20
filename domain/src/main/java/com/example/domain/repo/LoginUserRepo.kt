package com.example.domain.repo

import com.example.domain.core.Either
import com.example.domain.core.IFailure
import com.example.domain.model.User

interface LoginUserRepo {
    suspend fun loginUser(): Either<User, IFailure>
}
