package com.punkzieeee.core.domain.usecase

import com.punkzieeee.core.domain.model.F1Team
import com.punkzieeee.core.domain.repository.IF1Repository
import javax.inject.Inject

class F1Interactor @Inject constructor(private val f1Repository: IF1Repository) : F1UseCase {
    override fun getTeams() = f1Repository.getTeams()
    override fun getFavTeams() = f1Repository.getFavTeams()
    override fun setFavTeams(team: F1Team, state: Boolean) = f1Repository.setFavTeams(team, state)
}