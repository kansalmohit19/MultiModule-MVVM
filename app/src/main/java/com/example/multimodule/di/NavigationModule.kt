package com.example.multimodule.di

import com.example.multimodule.navigation.NavControllerProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideNavControllerProvider(): NavControllerProvider = NavControllerProvider()
}
