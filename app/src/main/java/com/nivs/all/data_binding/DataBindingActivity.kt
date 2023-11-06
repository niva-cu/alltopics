package com.nivs.all.data_binding

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nivs.all.R
import com.nivs.all.databinding.ActivityDatabindingBinding

class DataBindingActivity: AppCompatActivity() {
    lateinit var binding : ActivityDatabindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)

        val book1 = Book("ABC","Mr. XYZ")
        binding.book = book1

        val book2 = Book("Android","Google")
        binding.button1.setOnClickListener {
            binding.book = book2
        }

        Log.d("Main2 ","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Main2 ","onStart")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("Main2 ","onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("Main2 ","onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Main2 ","onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("Main2 ","onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("Main2 ","onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("Main2 ","onRestoreInstanceState")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.d("Main2 ","onPostCreate")
    }
    override fun onPostResume() {
        super.onPostResume()
        Log.d("Main2 ","onPostResume")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main2 ","onDestroy")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d("Main2 ","onAttachedToWindow")
    }
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d("Main2 ","onDetachedFromWindow")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("Main2 ","onConfigurationChanged")
    }
}