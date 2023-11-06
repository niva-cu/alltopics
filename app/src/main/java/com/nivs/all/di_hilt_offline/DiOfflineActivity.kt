package com.nivs.all.di_hilt_offline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nivs.all.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiOfflineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_di_offline)
    }
}