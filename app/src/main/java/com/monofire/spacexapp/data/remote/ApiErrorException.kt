package com.monofire.spacexapp.data.remote

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 14:17          │
//└─────────────────────────────┘
class ApiErrorException(
    val errorMessage: String? = null,
) : Exception(errorMessage)