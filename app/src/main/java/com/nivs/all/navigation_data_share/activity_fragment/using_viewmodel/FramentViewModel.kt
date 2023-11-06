package com.nivs.all.navigation_data_share.activity_fragment.using_viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FramentViewModel : ViewModel() {
    val data = MutableLiveData<String>()

    fun setData(newdata : String){
        data.value = newdata
    }
}