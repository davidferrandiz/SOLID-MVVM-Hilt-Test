package com.example.architecture2021

import com.example.architecture2021.domain.Movie

fun getMovies() = (1..10).map {
    Movie(it, "Title $it", "https://www.shareicon.net/data/128x128/2015/11/25/677416_animal_16x16.png")
}