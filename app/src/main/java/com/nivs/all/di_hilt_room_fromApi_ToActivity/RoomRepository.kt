package com.nivs.all.di_hilt_room_fromApi_ToActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nivs.all.di_hilt_room.ModelAPI
import com.nivs.all.di_hilt_room.Product
import javax.inject.Inject

class RoomRepository @Inject constructor(private val fakerAPI: ModelAPI, private val fakerDB: ModelDB) {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        if (fakerDB.getFakerDAO().getProducts().isNotEmpty()) {
            _products.postValue(fakerDB.getFakerDAO().getProducts())
        } else {
            val result = fakerAPI.getProducts()
            if (result.isSuccessful && result.body() != null) {
                fakerDB.getFakerDAO().addProducts(result.body()!!)
                _products.postValue(fakerDB.getFakerDAO().getProducts())
            }
        }
    }
}