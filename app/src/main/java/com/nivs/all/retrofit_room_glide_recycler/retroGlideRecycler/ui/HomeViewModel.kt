package com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.data.MainRepository
import com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.data.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val progressBarStatus = MutableLiveData<Boolean>()

    fun fetchAllMovies() {
        progressBarStatus.value = true
        viewModelScope.launch {
            kotlin.runCatching {
                mainRepository.getAllMovies()
            }.onSuccess {
                movieList.postValue(it.body())
            }.onFailure {

            }

        }
        progressBarStatus.value = false
    }


}