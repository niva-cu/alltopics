package com.nivs.all.db_room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordsDatabase : RoomDatabase() {

    abstract fun wordDao() : WordDao

}