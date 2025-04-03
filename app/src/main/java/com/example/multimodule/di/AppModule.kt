package com.example.multimodule.di

import com.example.multimodule.navigation.NavigatorImpl
import com.example.navigator.INavigateTo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindNavigator(navigatorImpl: NavigatorImpl): INavigateTo
}