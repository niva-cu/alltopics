package com.nivs.all.di_hilt_room_fromApi_ToActivity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nivs.all.R
import com.nivs.all.databinding.ActivityDiBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDiBinding
    lateinit var mainViewModel: RoomViewModel

    private val products: TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[RoomViewModel::class.java]
        mainViewModel.productsLiveData.observe(this, Observer {
            if(it.isNotEmpty()) {
                binding.pgBar.visibility = View.GONE
            }
            products.text =  it.joinToString { x -> x.title + "\n\n" }
            Toast.makeText(this, "Data from Room", Toast.LENGTH_SHORT).show()
        })
    }

}