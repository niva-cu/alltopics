package com.nivs.all.coroutine.coroutine1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.nivs.all.coroutine.coroutine1.adapter.MovieAdapter
import com.nivs.all.coroutine.coroutine1.remote.Repository
import com.nivs.all.coroutine.coroutine1.remote.RetrofitService
import com.nivs.all.coroutine.coroutine1.viewmodel.MovieViewModel
import com.nivs.all.coroutine.coroutine1.viewmodel.MovieViewModelFactory
import com.nivs.all.databinding.ActivityCoroutineEgBinding


//https://www.youtube.com/watch?v=Hqmi-xWUWCU
class MainCoroutineActivity : AppCompatActivity() {

    lateinit var viewmodel : MovieViewModel
    private val adapter= MovieAdapter()
    lateinit var binding :ActivityCoroutineEgBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityCoroutineEgBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val retrofitService= RetrofitService.getInstance()
        val repository = Repository(retrofitService)

        viewmodel= ViewModelProvider(this, MovieViewModelFactory(repository)).get(MovieViewModel::class.java)

         binding.recyclerview.adapter = adapter

         viewmodel.movielist.observe(this)
         {
             adapter.setMovies(it)
         }

        viewmodel.errormsg.observe(this)
        {

        }

         viewmodel.loading.observe(this,{
             if(it)
             {
                 binding.progressDialog.visibility= View.VISIBLE
             }
             else
             {
                 binding.progressDialog.visibility= View.GONE
             }
         })
        viewmodel.getMovies()


    }
}