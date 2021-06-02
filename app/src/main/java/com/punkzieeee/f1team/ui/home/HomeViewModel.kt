package com.punkzieeee.f1team.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.punkzieeee.core.domain.usecase.F1UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(f1UseCase: F1UseCase) : ViewModel() {
    val team = f1UseCase.getTeams().asLiveData()
}