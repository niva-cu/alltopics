package com.nivs.all.viewmodel_factory

import androidx.lifecycle.ViewModel

class MainVMFactorymodel(val initialValue: Int) : ViewModel() {
    var count : Int = initialValue

    fun changeData(){
        count++
    }
}