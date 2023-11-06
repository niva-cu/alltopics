package com.nivs.all.livedata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nivs.all.R

class MainLiveDataActivity: AppCompatActivity() {
    lateinit var mainLiveDataModel: MainLiveDataModel

    private val textView1 : TextView
        get() =  findViewById(R.id.textview_first)

    private val textView2 : TextView
        get() =  findViewById(R.id.textview_sec)

    private val button : Button
        get() =  findViewById(R.id.button_first)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first)

        mainLiveDataModel = ViewModelProvider(this).get(MainLiveDataModel::class.java)

        mainLiveDataModel.mutableLiveData.observe(this) {
            textView1.text = it
        }
        mainLiveDataModel.liveData.observe(this) {
            textView2.text = it
        }

        button.setOnClickListener{
            mainLiveDataModel.updateLiveData()
        }
    }
}