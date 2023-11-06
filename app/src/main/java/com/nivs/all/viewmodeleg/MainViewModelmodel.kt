package com.nivs.all.viewmodeleg

import androidx.lifecycle.ViewModel

class MainViewModelmodel: ViewModel() {
    var count : Int = 0

    fun changeData(){
        count++
    }
}