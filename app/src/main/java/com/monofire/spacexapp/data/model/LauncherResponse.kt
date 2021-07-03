package com.monofire.spacexapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Launchers")
data class LauncherResponse(

    @PrimaryKey() @SerializedName("flight_number") val flightNumber: Int,
    @SerializedName("mission_name") val missionName: String? = null,
    @SerializedName("upcoming") val upComing: Boolean? = null,
    @SerializedName("launch_year") val launchYear: Int? = null,
    @SerializedName("launch_date_unix") val launchDateUnix: Int? = null,
    @SerializedName("launch_date_utc") val launchDateUtc: String? = null,
    @SerializedName("launch_date_local") val launchDateLocal: String? = null,
    @SerializedName("rocket") val rocket: Rocket? = null,
    @SerializedName("links") val links: Links? = null,
    @SerializedName("details") val details: String? = null,
    @SerializedName("static_fire_date_utc") val staticFireDateUtc: String? = null
)
