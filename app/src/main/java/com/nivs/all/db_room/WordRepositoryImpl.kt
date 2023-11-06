package com.nivs.all.db_room

import androidx.lifecycle.LiveData
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(private val wordDao: WordDao) : WordRepository {
    override suspend fun insertWord(word: Word) {
        wordDao.insertWord(word)
    }

    override fun getAllWord(): LiveData<List<Word>> {
        return wordDao.getAllWord()
    }
}