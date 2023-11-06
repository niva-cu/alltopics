package com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.data

import retrofit2.Response

interface MainRepository {

    fun saveMovie(movieList: List<Movie>)
    suspend fun getAllMovies() : Response<List<Movie>>

    suspend fun getVersion() : Response<Int>


}