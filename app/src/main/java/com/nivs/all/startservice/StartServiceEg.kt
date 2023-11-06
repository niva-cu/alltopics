package com.nivs.all.startservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.databinding.ActivityServiceEgBinding

class StartServiceEg: AppCompatActivity() {

    private lateinit var binding: ActivityServiceEgBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceEgBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener{
            startService(Intent(this, MediaplayService::class.java))
        }

        binding.stopBtn.setOnClickListener{
            stopService(Intent(this, MediaplayService::class.java))
        }

    }
}