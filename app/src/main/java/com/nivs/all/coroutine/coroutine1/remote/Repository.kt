package com.nivs.all.coroutine.coroutine1.remote

class Repository  constructor(private val retrofitService: RetrofitService){

    suspend fun getMovies()=retrofitService.getMovies()




}