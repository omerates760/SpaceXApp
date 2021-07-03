package com.monofire.spacexapp.data.repository

import com.monofire.spacexapp.data.remote.ApiErrorException
import com.monofire.spacexapp.util.Resource
import retrofit2.Response

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 14:16          │
//└─────────────────────────────┘
abstract class BaseRepository {
    protected suspend fun <T> performApiCall(call: suspend () -> Response<T>): Resource<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (exception: Exception) {
            return Resource.ApiError(exception)
        }
        return if (response.isSuccessful) {
            Resource.Success(response.body()!!)
        } else {
            Resource.ApiError(handleError(response.message()))
        }
    }

    private fun handleError(status: String?): ApiErrorException {
        return ApiErrorException(
            status
        )
    }

}