package com.punkzieeee.core.di

import com.punkzieeee.core.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val hostname = "www.thesportsdb.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/ctt1haazs8U6LJbBhG1dMDCxflw6Q5LRFqlJP+iCf3E=")
            .add(hostname, "sha256/ctt1haazs8U6LJbBhG1dMDCxflw6Q5LRFqlJP+iCf3E=")
            .add(hostname, "sha256/ctt1haazs8U6LJbBhG1dMDCxflw6Q5LRFqlJP+iCf3E=")
            .add(hostname, "sha256/ctt1haazs8U6LJbBhG1dMDCxflw6Q5LRFqlJP+iCf3E=")
            .build()
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }

    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}