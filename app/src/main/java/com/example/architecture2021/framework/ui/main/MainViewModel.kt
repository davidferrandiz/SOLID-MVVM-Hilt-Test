package com.example.architecture2021.framework.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture2021.data.repositories.MoviesRepository
import com.example.architecture2021.domain.Movie
import com.example.architecture2021.framework.data.datasource.RemoteMovieDatasource
import com.example.architecture2021.usecases.LoadPopularMoviesUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loadPopularMoviesUseCase: LoadPopularMoviesUseCase) : ViewModel() {

    private val progressMutableLiveData = MutableLiveData<Boolean>()
    val progressLiveData: LiveData<Boolean> get() = progressMutableLiveData

    private val moviesMutableLiveData = MutableLiveData<List<Movie>>()
    val moviesLiveData: LiveData<List<Movie>> get() = moviesMutableLiveData

    private val messageMutableLiveData = MutableLiveData<String>()
    val messageLiveData: LiveData<String> get() = messageMutableLiveData

    fun onCreate() {
        viewModelScope.launch {
            progressMutableLiveData.value = true;
            moviesMutableLiveData.value = loadPopularMoviesUseCase.invoke()
            progressMutableLiveData.value = false
        }
    }

    fun onMovieClicked(movie: Movie) {
        messageMutableLiveData.value = movie.title
    }
}