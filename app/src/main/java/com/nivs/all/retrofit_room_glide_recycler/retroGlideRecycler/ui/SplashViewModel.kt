package com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler.data.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    val version = MutableLiveData<Int>()
    val progressBarStatus = MutableLiveData<Boolean>()
    fun checkVersion() {
        viewModelScope.launch {
            delay(2000)
            kotlin.runCatching {
                val response = mainRepository.getVersion()
                response.body()
            }.onSuccess {
                version.value = it
            }.onFailure {

            }
        }
    }

}