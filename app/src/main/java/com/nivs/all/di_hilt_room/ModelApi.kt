package com.nivs.all.di_hilt_room

import retrofit2.Response
import retrofit2.http.GET

interface ModelAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}