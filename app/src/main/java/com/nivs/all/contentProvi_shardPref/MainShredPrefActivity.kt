package com.nivs.all.contentProvi_shardPref

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.databinding.ActivityPusnotificationBinding

class MainShredPrefActivity:AppCompatActivity() {
    private lateinit var binding : ActivityPusnotificationBinding
    private lateinit var sharedPreference:SharedPreferences
    private lateinit var editor: Editor
    var name = "ABC"
    var age = 1

    //https://guides.codepath.com/android/Storing-and-Accessing-SharedPreferences
    //to get default preference file
    //First, add the following dependency:
    //implementation 'androidx.preference:preference:1.1.1'
    //val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPusnotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.text = "Create SP"
        binding.button2.text = "Add Data"
        binding.button3.text = "Get Data"
        binding.button4.text = "Delete/Remove some Data"
        binding.button5.text = "Clear Pref"
        binding.button6.text = "Delete Pref"

        binding.button1.setOnClickListener {
            sharedPreference = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
            editor = sharedPreference.edit()
        }

        binding.button2.setOnClickListener {
            if(binding.editText.text.isNotEmpty() && binding.editText2.text.isNotEmpty()
                && binding.editText3.text.isNotEmpty()) {
                //editor = sharedPreference.edit()
                editor.putString("username", binding.editText.text.toString())
                editor.putBoolean("done", true)
                editor.putInt("age", 100)
                editor.commit()
            } else {
                Toast.makeText(this, "Enter some data", Toast.LENGTH_SHORT).show()
            }
        }

        binding.button3.setOnClickListener {
            sharedPreference = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
                if (sharedPreference.contains("username")) {
                    name = sharedPreference.getString("username", "").toString()
                    age = sharedPreference.getInt("age", 0)
                    Toast.makeText(this, "Entered $name  $age", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show()
                }
        }

        binding.button4.setOnClickListener {
            sharedPreference = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
            if (sharedPreference.contains("username")) {
                editor.remove("username")
                editor.apply()
                name = sharedPreference.getString("username", "").toString()
                Toast.makeText(this, "Entered $name  $age", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show()
            }

        }

        binding.button5.setOnClickListener {
            editor.clear()
            editor.apply()
        }
    }


}