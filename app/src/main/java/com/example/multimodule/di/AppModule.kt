package com.example.multimodule.di

import com.example.multimodule.navigation.AppNavigationManager
import com.example.navigator.NavigationManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindAppNavigationManager(appNavigationManager: AppNavigationManager): NavigationManager
}