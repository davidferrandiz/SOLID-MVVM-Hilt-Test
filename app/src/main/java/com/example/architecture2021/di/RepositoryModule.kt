package com.example.architecture2021.di

import com.example.architecture2021.data.datasources.RemoteDatasource
import com.example.architecture2021.data.repositories.MoviesRepository
import com.example.architecture2021.framework.data.datasource.RemoteMovieDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMovieRepository(movieDatasource: RemoteDatasource, @Named("apiKey")  apiKey: String) =
        MoviesRepository(movieDatasource, apiKey)
}