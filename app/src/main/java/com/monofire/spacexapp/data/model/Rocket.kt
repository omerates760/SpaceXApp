package com.monofire.spacexapp.data.model

import com.google.gson.annotations.SerializedName


data class Rocket(

    @SerializedName("rocket_id") val rocketId: String? = null,
    @SerializedName("rocket_name") val rocketName: String? = null,
    @SerializedName("rocket_type") val rocketType: String? = null,
)