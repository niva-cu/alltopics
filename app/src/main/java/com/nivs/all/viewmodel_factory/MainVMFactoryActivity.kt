package com.nivs.all.viewmodel_factory

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nivs.all.R

class MainVMFactoryActivity: AppCompatActivity() {
    lateinit var mainViewModelmodel: MainVMFactorymodel

    lateinit var textView2 : TextView

    private val button : Button
        get() =  findViewById(R.id.button_first)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first)

        mainViewModelmodel = ViewModelProvider(this, MainViewModelfactory(10)).get(MainVMFactorymodel::class.java)
        textView2 =  findViewById(R.id.textview_sec)
        textView2.text = mainViewModelmodel.count.toString()

        button.setOnClickListener{
            mainViewModelmodel.changeData()
            textView2.text = mainViewModelmodel.count.toString()
        }
    }
}