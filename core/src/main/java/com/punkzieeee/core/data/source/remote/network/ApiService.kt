package com.punkzieeee.core.data.source.remote.network

import com.punkzieeee.core.data.source.remote.response.ListF1Response
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("lookup_all_teams.php?id=4370")
    suspend fun getList(): ListF1Response
}