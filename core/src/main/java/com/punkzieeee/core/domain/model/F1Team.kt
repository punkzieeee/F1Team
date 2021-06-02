package com.punkzieeee.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class F1Team (
    val idTeam: String,
    val intFormedYear: String,
    val strCountry: String,
    val strDescriptionEN: String,
    val strStadiumLocation: String,
    val strTeam: String,
    val strTeamLogo: String,
    val strTeamFanart1: String?,
    val strTeamFanart2: String?,
    val strTeamFanart3: String?,
    val strTeamFanart4: String?,
    val strTeamBanner: String?,
    val strWebsite: String,
    val favorite: Boolean = false
) : Parcelable