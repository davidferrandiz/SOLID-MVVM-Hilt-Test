package com.example.architecture2021.di

import com.example.architecture2021.data.repositories.MoviesRepository
import com.example.architecture2021.usecases.LoadPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideLoadPopularMoviesUseCase(repository: MoviesRepository) = LoadPopularMoviesUseCase(repository)
}