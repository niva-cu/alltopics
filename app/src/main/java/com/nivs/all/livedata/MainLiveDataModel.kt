package com.nivs.all.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainLiveDataModel: ViewModel() {
    val mutableLiveData = MutableLiveData<String>("This is MutableLiveData")

    val liveData = MutableLiveData<String>("This is LiveData")

    fun updateLiveData(){
        mutableLiveData.value = "Updated Mutable LiveData"
        liveData.value = "Updated LiveData"
    }
}