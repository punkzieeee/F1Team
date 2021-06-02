package com.punkzieeee.core.data.source.local.room

import androidx.room.*
import com.punkzieeee.core.data.source.local.entity.F1Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface F1Dao {
    @Query("SELECT * FROM teamentities")
    fun getTeam(): Flow<List<F1Entity>>

    @Query("SELECT * FROM teamentities where favorite = 1")
    fun getFavTeam(): Flow<List<F1Entity>>

    @Query("SELECT * FROM teamentities WHERE idTeam = :id")
    fun getDetailTeam(id: String): Flow<F1Entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: List<F1Entity>)

    @Update
    fun updateTeam(team: F1Entity)
}