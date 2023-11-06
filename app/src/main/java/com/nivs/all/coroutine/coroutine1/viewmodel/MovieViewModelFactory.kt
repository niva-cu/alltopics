package com.nivs.all.coroutine.coroutine1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nivs.all.coroutine.coroutine1.remote.Repository
import java.lang.IllegalArgumentException

class MovieViewModelFactory constructor(val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        return if(modelClass.isAssignableFrom(MovieViewModel::class.java))
        {
            MovieViewModel(this.repository) as T
        }
      else
        {
            throw IllegalArgumentException("view model not found ")
        }


    }


}