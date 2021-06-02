package com.punkzieeee.core.data

import com.punkzieeee.core.domain.model.F1Team
import com.punkzieeee.core.domain.repository.IF1Repository
import com.punkzieeee.core.util.AppExecutors
import com.punkzieeee.core.util.DataMapper
import com.punkzieeee.core.data.source.local.LocalDataSource
import com.punkzieeee.core.data.source.remote.RemoteDataSource
import com.punkzieeee.core.data.source.remote.network.ApiResponse
import com.punkzieeee.core.data.source.remote.response.F1Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class F1Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IF1Repository {
    override fun getTeams(): Flow<Resource<List<F1Team>>> {
        return object : NetworkBoundResource<List<F1Team>, List<F1Response>>() {
            override fun loadFromDB(): Flow<List<F1Team>> {
                return localDataSource.getTeams().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<F1Team>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<F1Response>>> = remoteDataSource.getTeams()

            override suspend fun saveCallResult(data: List<F1Response>) {
                val list = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTeam(list)
            }
        }.asFlow()
    }

    override fun getFavTeams(): Flow<List<F1Team>> {
        return localDataSource.getFavTeams().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavTeams(team: F1Team, state: Boolean) {
        val entity = DataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute{ localDataSource.setFavTeam(entity, state) }
    }
}