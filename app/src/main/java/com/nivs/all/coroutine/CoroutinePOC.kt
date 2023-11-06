package com.nivs.all.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinePOC: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            val user = fetchUser()
            // show user
        }
    }

    suspend fun fetchUser() {
        return withContext(Dispatchers.IO) {
            // fetch user
            // return user
        }
    }

}

class User {

}