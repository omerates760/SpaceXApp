package com.monofire.spacexapp.data.remote.service

import com.monofire.spacexapp.data.model.LauncherResponse
import retrofit2.Response
import retrofit2.http.GET

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 09:46          │
//└─────────────────────────────┘
interface LauncherApi {
    @GET("v2/launches")
    suspend fun fetchLaunches(): Response<List<LauncherResponse>>
}