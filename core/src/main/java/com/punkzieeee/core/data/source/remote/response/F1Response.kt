package com.punkzieeee.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class F1Response(
    @field:SerializedName("idTeam")
    var idTeam: String,
    @field:SerializedName("intFormedYear")
    var intFormedYear: String,
    @field:SerializedName("strCountry")
    var strCountry: String,
    @field:SerializedName("strDescriptionEN")
    var strDescriptionEN: String,
    @field:SerializedName("strStadiumLocation")
    var strStadiumLocation: String,
    @field:SerializedName("strTeam")
    var strTeam: String,
    @field:SerializedName("strTeamLogo")
    var strTeamLogo: String,
    @field:SerializedName("strTeamFanart1")
    var strTeamFanart1: String?,
    @field:SerializedName("strTeamFanart2")
    var strTeamFanart2: String?,
    @field:SerializedName("strTeamFanart3")
    var strTeamFanart3: String?,
    @field:SerializedName("strTeamFanart4")
    var strTeamFanart4: String?,
    @field:SerializedName("strTeamBanner")
    var strTeamBanner: String?,
    @field:SerializedName("strWebsite")
    var strWebsite: String
): Parcelable
