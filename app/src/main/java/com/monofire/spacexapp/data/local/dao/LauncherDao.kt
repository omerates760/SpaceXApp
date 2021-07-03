package com.monofire.spacexapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.monofire.spacexapp.data.model.LauncherResponse

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 14:24          │
//└─────────────────────────────┘
@Dao
interface LauncherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLaunchers(cryptoCurrencies: List<LauncherResponse>)

    @Query("SELECT * FROM Launchers WHERE launchYear LIKE :year")
    fun filterLauncher(year: String): List<LauncherResponse>
}