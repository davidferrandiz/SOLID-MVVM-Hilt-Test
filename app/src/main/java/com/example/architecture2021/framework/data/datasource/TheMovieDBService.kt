package com.example.architecture2021.framework.data.datasource

import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDBService {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMovies(
        @Query("api_key") apiKey: String
    ): MovieDbResult
}