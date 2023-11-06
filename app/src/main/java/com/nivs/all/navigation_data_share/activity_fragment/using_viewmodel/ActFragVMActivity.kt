package com.nivs.all.navigation_data_share.activity_fragment.using_viewmodel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.R
import com.nivs.all.databinding.ActivityActfragVmBinding
import com.nivs.all.navigation_data_share.fragment_fragment.ThreeFragment
import com.nivs.all.navigation_data_share.fragment_fragment.TwoFragment

//https://www.youtube.com/watch?v=_aMEOCwb5Ls
class ActFragVMActivity:AppCompatActivity() {
    private lateinit var binding: ActivityActfragVmBinding
    private val framentViewModel : FramentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityActfragVmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOne.setOnClickListener(){
            framentViewModel.setData(binding.editTextFra.text.toString())
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, AnFragment()).commit()
        }
        binding.buttonTwo.setOnClickListener(){
            framentViewModel.setData(binding.editTextFra.text.toString())
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, AnotherFragment()).commit()
        }
    }

}