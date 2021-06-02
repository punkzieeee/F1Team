package com.punkzieeee.f1team.ui.detail

import androidx.lifecycle.ViewModel
import com.punkzieeee.core.domain.model.F1Team
import com.punkzieeee.core.domain.usecase.F1UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val f1UseCase: F1UseCase) : ViewModel() {
    fun setFavorite(team: F1Team, state: Boolean) = f1UseCase.setFavTeams(team, state)
}