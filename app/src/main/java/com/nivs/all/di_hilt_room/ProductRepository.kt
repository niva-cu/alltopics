package com.nivs.all.di_hilt_room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: ModelAPI) {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts(){
        val result = fakerAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        } else {
            //_products.postValue("Change Retrofit object in NetworkModule.kt")
        }
    }

}