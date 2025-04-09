package com.example.domain.repo

import com.example.core.Either
import com.example.core.IFailure
import com.example.domain.model.User

interface LoginUserRepo {
    fun loginUser(): Either<User, IFailure>
}
