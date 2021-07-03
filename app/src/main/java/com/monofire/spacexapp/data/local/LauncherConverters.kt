package com.monofire.spacexapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.monofire.spacexapp.data.model.Links
import com.monofire.spacexapp.data.model.Rocket

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 15:53          │
//└─────────────────────────────┘
class LauncherConverters {
    @TypeConverter
    fun fromToRocket(value: String?): Rocket? {
        return Gson().fromJson(value, Rocket::class.java)
    }

    @TypeConverter
    fun rocketToString(rocket: Rocket?): String? {
        return Gson().toJson(rocket, Rocket::class.java)
    }

    @TypeConverter
    fun fromToLinks(value: String?): Links? {
        return Gson().fromJson(value, Links::class.java)
    }

    @TypeConverter
    fun linksToString(links: Links?): String? {
        return Gson().toJson(links, Links::class.java)
    }
}