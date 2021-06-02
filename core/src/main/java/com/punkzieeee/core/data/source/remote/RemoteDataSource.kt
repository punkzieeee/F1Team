package com.punkzieeee.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.punkzieeee.core.data.source.remote.network.ApiResponse
import com.punkzieeee.core.data.source.remote.network.ApiService
import com.punkzieeee.core.data.source.remote.response.F1Response
import com.punkzieeee.core.data.source.remote.response.ListF1Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getTeams(): Flow<ApiResponse<List<F1Response>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.teams
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.teams))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}