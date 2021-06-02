package com.punkzieeee.core.data.source.local

import com.punkzieeee.core.data.source.local.entity.F1Entity
import com.punkzieeee.core.data.source.local.room.F1Dao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val f1Dao: F1Dao) {
    fun getTeams(): Flow<List<F1Entity>> = f1Dao.getTeam()
    fun getFavTeams(): Flow<List<F1Entity>> = f1Dao.getFavTeam()
    suspend fun insertTeam(team: List<F1Entity>) = f1Dao.insertTeam(team)
    fun setFavTeam(team: F1Entity, state: Boolean) {
        team.favorite = state
        f1Dao.updateTeam(team)
    }
}