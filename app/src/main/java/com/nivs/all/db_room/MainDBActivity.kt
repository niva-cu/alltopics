package com.nivs.all.db_room

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nivs.all.databinding.ActivityMaindbBinding
import dagger.hilt.android.AndroidEntryPoint
//https://www.youtube.com/watch?v=UlqTh795Jbg
@AndroidEntryPoint
class MainDBActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMaindbBinding
    private val viewModel: MainDBViewModel by viewModels()
    private var word: String  = ""
    private lateinit var userAdapter : WordsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaindbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDB1.apply {
            userAdapter = WordsAdapter()
            layoutManager = LinearLayoutManager(this@MainDBActivity)
            adapter = userAdapter
        }


        binding.btnAdd.setOnClickListener(){
            word =  binding.eT.text.toString()
            if(word.isNotEmpty())
            viewModel.saveWord(word).observe(this@MainDBActivity){
                if (it){
                    Toast.makeText(this@MainDBActivity, "Success", Toast.LENGTH_LONG).show()
                } else
                    Toast.makeText(this@MainDBActivity, "Failure", Toast.LENGTH_LONG).show()
            }
        }

        viewModel.getAllWord().observe(this){
            userAdapter.submitList(it)

        }
    }
}