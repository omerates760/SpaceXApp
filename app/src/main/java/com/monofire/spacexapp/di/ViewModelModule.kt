package com.monofire.spacexapp.di

import com.monofire.spacexapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 09:43          │
//└─────────────────────────────┘
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}