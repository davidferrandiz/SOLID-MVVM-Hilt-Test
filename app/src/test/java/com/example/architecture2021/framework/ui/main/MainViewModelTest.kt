package com.example.architecture2021.framework.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.architecture2021.domain.Movie
import com.example.architecture2021.usecases.LoadPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class MainViewModelTest {

    @Mock
    lateinit var loadPopularMoviesUseCase: LoadPopularMoviesUseCase

    @Mock
    lateinit var observer: Observer<List<Movie>>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `onCreate loads popular movies`() {
        runBlockingTest {
            val fakeList = listOf(Movie(1, "title 1", "poster1.jpg"))

            `when`(loadPopularMoviesUseCase.invoke()).thenReturn(fakeList)

            val viewModel = MainViewModel(loadPopularMoviesUseCase)
            viewModel.moviesLiveData.observeForever(observer)

            viewModel.onCreate()

            verify(observer).onChanged(fakeList)
        }
    }

}