package com.punkzieeee.f1team.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.punkzieeee.core.domain.usecase.F1UseCase

class FavoriteViewModel (f1UseCase: F1UseCase) : ViewModel() {
    val favTeam = f1UseCase.getFavTeams().asLiveData()
}