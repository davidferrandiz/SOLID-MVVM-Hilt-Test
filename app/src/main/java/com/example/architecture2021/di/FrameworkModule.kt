package com.example.architecture2021.di

import com.example.architecture2021.framework.data.datasource.TheMovieDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider() = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(): String = "d30e1f350220f9aad6c4110df385d380"

    @Provides
    @Singleton
    fun retrofitProvider(@Named("baseUrl") baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}