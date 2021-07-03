package com.monofire.spacexapp.util

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 14:17          │
//└─────────────────────────────┘
sealed class Resource<out T> {

    class Success<T>(val value: T) : Resource<T>()
    object EmptySuccess : Resource<Nothing>()

    class ApiError<T>(val error: Throwable) : Resource<T>()

    object Loading : Resource<Nothing>()

    fun onSuccess(successHandler: (T) -> Unit): Resource<T> = this.also {
        when (this) {
            is Success -> successHandler(value)
        }
    }

    fun onEmptySuccess(successHandler: () -> Unit): Resource<T> = this.also {
        when (this) {
            is EmptySuccess -> successHandler()
        }
    }

    fun onApiError(errorHandler: (Throwable) -> Unit): Resource<T> = this.also {
        when (this) {
            is ApiError -> errorHandler(error)
        }
    }

    fun onLoading(loadingHandler: () -> Unit): Resource<T> = this.also {
        when (this) {
            is Loading -> loadingHandler()
        }
    }
}