package com.monofire.spacexapp.di

import com.monofire.spacexapp.BuildConfig
import com.monofire.spacexapp.data.remote.service.LauncherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 09:43          │
//└─────────────────────────────┘
val networkModule = module {
    single { createOkHttpClient() }
    single { createRetrofit(get()) }
    factory { createWebService<LauncherApi>(retrofit = get()) }

}

fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(createHttpLoggingInterceptor(BuildConfig.DEBUG))
        .build()
}

private fun createHttpLoggingInterceptor(debugMode: Boolean): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    if (debugMode) httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    else httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
    return httpLoggingInterceptor

}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

inline fun <reified T> createWebService(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}