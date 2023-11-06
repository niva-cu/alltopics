package com.nivs.all.data_binding_twoway

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingTwowayViewmodel: ViewModel() {
    val liveData = MutableLiveData<String>("This is MutableLiveData")
    val liveData2 = MutableLiveData<String>("Data Binding eg")

    fun updateLiveData(){
        liveData.value = "Updated LiveData"
    }
}