package com.nivs.all.data_binding_twoway

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nivs.all.R
import com.nivs.all.data_binding.Book
import com.nivs.all.data_binding.DataBindingActivity
import com.nivs.all.databinding.ActivityDatabindingTwowayBinding

class DataBindingTwowayActivity: AppCompatActivity() {
    lateinit var mainLiveDataModel: DataBindingTwowayViewmodel
    private lateinit var binding : ActivityDatabindingTwowayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_twoway)

        mainLiveDataModel = ViewModelProvider(this).get(com.nivs.all.data_binding_twoway.DataBindingTwowayViewmodel::class.java)

        binding.twowayviewmodel = mainLiveDataModel
       /* binding.btn1.setOnClickListener {
           mainLiveDataModel.updateLiveData()
        }*/

        binding.lifecycleOwner = this
        /*mainLiveDataModel.liveData.observe(this) {
            binding.text1.text = it
        }*/

        binding.btn2.setOnClickListener {
            var intent = Intent(applicationContext, DataBindingActivity::class.java)
            startActivity(intent)
        }
        Log.d("Main1 ","onCreate")
    }



    override fun onStart() {
        super.onStart()
        Log.d("Main1 ","onStart")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("Main1 ","onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("Main1 ","onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Main1 ","onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("Main1 ","onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("Main1 ","onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("Main1 ","onRestoreInstanceState")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.d("Main1 ","onPostCreate")
    }
    override fun onPostResume() {
        super.onPostResume()
        Log.d("Main1 ","onPostResume")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main1 ","onDestroy")
    }
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d("Main1 ","onAttachedToWindow")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d("Main1 ","onDetachedFromWindow")
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("Main1 ","onConfigurationChanged")
    }

}