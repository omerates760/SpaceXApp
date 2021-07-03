package com.monofire.spacexapp.data.model

import com.google.gson.annotations.SerializedName


data class Links(

    @SerializedName("mission_patch") val missionPatch: String? = null,
    @SerializedName("mission_patch_small") val missionPatchSmall: String? = null
)