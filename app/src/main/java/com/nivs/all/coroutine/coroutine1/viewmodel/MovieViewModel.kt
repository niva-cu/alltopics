package com.nivs.all.coroutine.coroutine1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nivs.all.coroutine.coroutine1.model.Movie
import com.nivs.all.coroutine.coroutine1.remote.Repository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher

class MovieViewModel constructor(private val repository: Repository):ViewModel() {


    val movielist =MutableLiveData<List<Movie>>()

    val errormsg = MutableLiveData<String>()

    var handlejob: Job? = null

    val loading = MutableLiveData<Boolean>()





     val exceptionHandler= CoroutineExceptionHandler{_,throwable->onError(

         "Excption :${throwable.localizedMessage}"
     )

     }

    private fun onError(msg: String) {

        errormsg.value= msg
        loading.value=false

    }

    override fun onCleared() {
        super.onCleared()

        handlejob?.cancel()
    }

    fun getMovies() {


        handlejob= CoroutineScope(Dispatchers.IO+exceptionHandler).launch {

            val response = repository.getMovies()
            withContext(Dispatchers.Main)
            {
                if(response.isSuccessful)
                {
                    movielist.postValue(response.body())
                    loading.value =false

                }
                else
                {
                   onError("Error:${response.message()}")
                }
            }

        }



            }
}