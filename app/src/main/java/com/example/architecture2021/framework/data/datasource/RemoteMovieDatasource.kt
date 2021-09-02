package com.example.architecture2021.framework.data.datasource

import com.example.architecture2021.data.datasources.RemoteDatasource
import com.example.architecture2021.domain.Movie
import com.example.architecture2021.getMovies


class RemoteMovieDatasource(private val theMovieDBService: TheMovieDBService) : RemoteDatasource {

    override suspend fun getPopularMovies(apiKey: String) : List<Movie> {
        val serverResult = theMovieDBService.listPopularMovies(apiKey)
        return serverResult.results.map { serverMovie ->
            Movie(serverMovie.id, serverMovie.title, serverMovie.posterPath)
        }
    }
}