package com.punkzieeee.core.di

import com.punkzieeee.core.data.F1Repository
import com.punkzieeee.core.domain.repository.IF1Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(f1Repository: F1Repository): IF1Repository
}