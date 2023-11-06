package com.nivs.all.db_room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Provides
    fun provideWordDatabase(@ApplicationContext context: Context) : WordsDatabase{
        return Room.databaseBuilder(context, WordsDatabase::class.java, "words.db").build()
    }

    @Provides
    fun provideWordDao(wordsDatabase: WordsDatabase):WordDao{
        return wordsDatabase.wordDao()
    }
}