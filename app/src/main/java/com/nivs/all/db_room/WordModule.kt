package com.nivs.all.db_room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class)
@Module
object WordModule {

    @Provides
    fun provideWordRepository(wordDao: WordDao) : WordRepository{
        return WordRepositoryImpl(wordDao)
    }

   /* @Provides
    fun provideWordDao(wordDB: WordDao) : WordDao{
        return wordDB.getWordDAO()
    }*/
}