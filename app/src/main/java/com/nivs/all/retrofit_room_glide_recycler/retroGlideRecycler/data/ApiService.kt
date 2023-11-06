package com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.data

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("movielist.json")
    suspend fun getAllMovies() : Response<List<Movie>>
}