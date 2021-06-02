package com.punkzieeee.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teamentities")
data class F1Entity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,
    @ColumnInfo(name = "intFormedYear")
    var intFormedYear: String,
    @ColumnInfo(name = "strCountry")
    var strCountry: String,
    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEN: String,
    @ColumnInfo(name = "strStadiumLocation")
    var strStadiumLocation: String,
    @ColumnInfo(name = "strTeam")
    var strTeam: String,
    @ColumnInfo(name = "strTeamLogo")
    var strTeamLogo: String,
    @ColumnInfo(name = "strTeamFanart1")
    var strTeamFanart1: String?,
    @ColumnInfo(name = "strTeamFanart2")
    var strTeamFanart2: String?,
    @ColumnInfo(name = "strTeamFanart3")
    var strTeamFanart3: String?,
    @ColumnInfo(name = "strTeamFanart4")
    var strTeamFanart4: String?,
    @ColumnInfo(name = "strTeamBanner")
    var strTeamBanner: String?,
    @ColumnInfo(name = "strWebsite")
    var strWebsite: String,
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)