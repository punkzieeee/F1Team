package com.punkzieeee.core.data.source

import androidx.lifecycle.LiveData
import com.punkzieeee.core.data.source.local.entity.F1Entity
import com.punkzieeee.core.data.Resource

interface F1DataSource {
    fun getTeams(): LiveData<Resource<List<F1Entity>>>
    fun getFavTeams(): LiveData<List<F1Entity>>
    fun getDetailTeam(id: String): LiveData<Resource<F1Entity>>
    fun setFavTeams(team: F1Entity, state: Boolean)
}