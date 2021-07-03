package com.monofire.spacexapp.di

import android.app.Application
import androidx.room.Room
import com.monofire.spacexapp.data.local.LauncherDatabase
import com.monofire.spacexapp.data.local.dao.LauncherDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 21:24          │
//└─────────────────────────────┘
val databaseModule = module {

    fun provideDatabase(application: Application): LauncherDatabase {
        return Room.databaseBuilder(application, LauncherDatabase::class.java, "launcherDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCountriesDao(database: LauncherDatabase): LauncherDao {
        return database.launcherDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideCountriesDao(get()) }
}