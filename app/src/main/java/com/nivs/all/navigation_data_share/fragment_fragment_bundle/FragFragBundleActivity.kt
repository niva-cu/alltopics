package com.nivs.all.navigation_data_share.fragment_fragment_bundle

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.R
import com.nivs.all.databinding.ActivityActfragVmBinding
import com.nivs.all.navigation_data_share.activity_fragment.using_viewmodel.AnFragment

//https://www.youtube.com/watch?v=dh-zw64LKLg
class FragFragBundleActivity: AppCompatActivity() {
    private lateinit var binding: ActivityActfragVmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActfragVmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, AnFragment()).commit()
    }
}