package com.example.architecture2021.data.datasources

import com.example.architecture2021.domain.Movie

interface RemoteDatasource {
    suspend fun getPopularMovies(apiKey: String): List<Movie>
}