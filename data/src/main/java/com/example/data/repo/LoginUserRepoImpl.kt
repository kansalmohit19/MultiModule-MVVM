package com.example.data.repo

import com.example.data.extensions.safeApiCall
import com.example.data.mapper.toDomain
import com.example.data.remote.DataSourceImpl
import com.example.domain.core.Either
import com.example.domain.core.IFailure
import com.example.domain.model.User
import com.example.domain.repo.LoginUserRepo
import javax.inject.Inject

class LoginUserRepoImpl @Inject constructor(private val dataSource: DataSourceImpl) :
    LoginUserRepo {
    override suspend fun loginUser(): Either<User, IFailure> {
        return safeApiCall(apiCall = { dataSource.loginUser() },
            successTransform = { it?.body()?.data.toDomain() })
    }
}
