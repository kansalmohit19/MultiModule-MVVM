package com.example.data.di

import com.example.data.repo.LoginUserRepoImpl
import com.example.domain.repo.LoginUserRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindLoginUserRepo(impl: LoginUserRepoImpl): LoginUserRepo
}