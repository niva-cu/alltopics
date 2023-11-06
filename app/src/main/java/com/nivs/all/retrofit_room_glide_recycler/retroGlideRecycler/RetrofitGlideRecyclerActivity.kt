package com.nivs.all.retrofit_room_glide_recycler.retroGlideRecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nivs.all.databinding.ActivityRetroGlideRecyclerBinding
import dagger.hilt.android.AndroidEntryPoint

//https://github.com/velmurugan-murugesan/Android-Example/tree/master/HiltAndroid

@AndroidEntryPoint
class RetrofitGlideRecyclerActivity : AppCompatActivity() {

    lateinit var binding: ActivityRetroGlideRecyclerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetroGlideRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}