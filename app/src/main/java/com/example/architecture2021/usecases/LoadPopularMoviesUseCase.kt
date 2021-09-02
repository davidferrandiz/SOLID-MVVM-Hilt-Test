package com.example.architecture2021.usecases

import com.example.architecture2021.data.repositories.MoviesRepository
import com.example.architecture2021.domain.Movie

class LoadPopularMoviesUseCase(private val repository: MoviesRepository) {

    suspend fun invoke(): List<Movie> = repository.getPopularMovies()

}