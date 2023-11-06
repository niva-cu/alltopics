package com.nivs.all.navigation_data_share.fragment_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.R

class FragFragActivity : AppCompatActivity() {
//https://proandroiddev.com/the-modern-way-to-pass-data-between-fragments-b305cabbf2f2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_frag)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,OneFragment()).commit()

    }
}