package com.monofire.spacexapp

import android.app.Application
import com.monofire.spacexapp.di.appModule
import com.monofire.spacexapp.di.databaseModule
import com.monofire.spacexapp.di.networkModule
import com.monofire.spacexapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module


// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 09:42           │
//└─────────────────────────────┘
class SpaceXApplication : Application() {
    private val moduleList: List<Module> = listOf(
        appModule, networkModule, viewModelModule, databaseModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SpaceXApplication)
            modules(moduleList)
        }
    }
}