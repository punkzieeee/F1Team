package com.punkzieeee.core.domain.usecase

import com.punkzieeee.core.data.Resource
import com.punkzieeee.core.domain.model.F1Team
import kotlinx.coroutines.flow.Flow

interface F1UseCase {
    fun getTeams(): Flow<Resource<List<F1Team>>>
    fun getFavTeams(): Flow<List<F1Team>>
    fun setFavTeams(team: F1Team, state: Boolean)
}