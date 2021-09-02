package com.example.architecture2021.di

import com.example.architecture2021.data.datasources.RemoteDatasource
import com.example.architecture2021.framework.data.datasource.RemoteMovieDatasource
import com.example.architecture2021.framework.data.datasource.TheMovieDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatasourceModule {

    @Provides
    fun provideMoviesRemoteDatasource(theMovieDBService: TheMovieDBService): RemoteDatasource =
        RemoteMovieDatasource(theMovieDBService)
}