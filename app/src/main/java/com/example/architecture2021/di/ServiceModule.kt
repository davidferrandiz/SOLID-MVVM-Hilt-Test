package com.example.architecture2021.di

import com.example.architecture2021.framework.data.datasource.TheMovieDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun theMovieDbRemoteServiceProvider(retrofit: Retrofit): TheMovieDBService =
        retrofit.create(TheMovieDBService::class.java)
}