package com.punkzieeee.f1team.di

import com.punkzieeee.core.domain.usecase.F1Interactor
import com.punkzieeee.core.domain.usecase.F1UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.*

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideF1UseCase(f1Interactor: F1Interactor): F1UseCase
}