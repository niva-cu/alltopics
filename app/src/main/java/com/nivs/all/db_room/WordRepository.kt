package com.nivs.all.db_room

import androidx.lifecycle.LiveData

interface WordRepository {
    suspend fun insertWord(word: Word)
    fun getAllWord() : LiveData<List<Word>>
}
