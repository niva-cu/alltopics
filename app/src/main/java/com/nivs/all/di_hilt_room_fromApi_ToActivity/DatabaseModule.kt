package com.nivs.all.di_hilt_room_fromApi_ToActivity

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDB(@ApplicationContext context : Context) : ModelDB{
        return Room.databaseBuilder(context, ModelDB::class.java, "FakerDB").build()
    }
}
