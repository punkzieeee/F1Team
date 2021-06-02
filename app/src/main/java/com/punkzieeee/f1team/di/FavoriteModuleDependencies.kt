package com.punkzieeee.f1team.di

import com.punkzieeee.core.domain.usecase.F1UseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun f1UseCase(): F1UseCase
}