package com.monofire.spacexapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.monofire.spacexapp.data.local.dao.LauncherDao
import com.monofire.spacexapp.data.model.LauncherResponse

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 14:18          │
//└─────────────────────────────┘
@Database(
    entities = [LauncherResponse::class],
    version = 1, exportSchema = false
)
@TypeConverters(LauncherConverters::class)
abstract class LauncherDatabase : RoomDatabase() {
    abstract val launcherDao: LauncherDao
}