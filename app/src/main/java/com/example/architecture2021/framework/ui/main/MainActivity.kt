package com.example.architecture2021.framework.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.architecture2021.R
import com.example.architecture2021.databinding.ActivityMainBinding
import com.example.architecture2021.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding : ActivityMainBinding
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setView()
        moviesAdapter = MoviesAdapter(viewModel::onMovieClicked)
        setRecyclerView()
        addObservers()

        viewModel.onCreate()
    }

    private fun setView() {
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setRecyclerView() {
        binding.recycler.layoutManager = GridLayoutManager(this, 2)
        binding.recycler.adapter = moviesAdapter
    }

    private fun addObservers() {
        viewModel.progressLiveData.observe(this, { binding.progress.visible = it })
        viewModel.moviesLiveData.observe(this, { moviesAdapter.movies = it })
        viewModel.messageLiveData.observe(
            this, { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() })
    }
}