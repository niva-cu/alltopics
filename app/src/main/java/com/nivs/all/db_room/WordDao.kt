package com.nivs.all.db_room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word : Word)

    @Delete()
    suspend fun deleteProducts(products : Word)

    @Query("SELECT * FROM words")
    fun getAllWord() : LiveData<List<Word>>

}