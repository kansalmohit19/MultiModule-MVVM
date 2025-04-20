package com.example.data.di

import android.os.Build
import com.example.common.Constants.CONST_10
import com.example.common.Constants.CONST_30
import com.example.data.remote.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.time.Duration
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(
                "https://raw.githubusercontent.com/" +
                    "kansalmohit19/JSONResponses/refs/heads/main/jsonfiles/"
            )
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor)
                .connectTimeout(Duration.ofSeconds(CONST_10.toLong())).readTimeout(
                    Duration.ofSeconds(
                        CONST_30.toLong()
                    )
                ).build()
        } else {
            OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor).build()
        }
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun providesAPIService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }
}
