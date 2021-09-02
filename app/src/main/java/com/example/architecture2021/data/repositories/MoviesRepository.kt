package com.example.architecture2021.data.repositories

import com.example.architecture2021.data.datasources.RemoteDatasource

class MoviesRepository(
    private val remoteDatasource: RemoteDatasource,
    private val apiKey: String
) {

    suspend fun getPopularMovies() = remoteDatasource.getPopularMovies(apiKey)
}

