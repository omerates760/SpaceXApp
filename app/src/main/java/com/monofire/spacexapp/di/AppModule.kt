package com.monofire.spacexapp.di

import com.monofire.spacexapp.data.repository.LauncherRepository
import org.koin.dsl.module


// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 09:42          │
//└─────────────────────────────┘
val appModule = module {
    single { LauncherRepository(get(),get()) }
}