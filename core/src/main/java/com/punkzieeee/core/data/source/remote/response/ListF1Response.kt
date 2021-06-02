package com.punkzieeee.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListF1Response(
    @field:SerializedName("teams")
    val teams: List<F1Response>
)
