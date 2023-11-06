package com.nivs.all.di_hilt_room_fromApi_ToActivity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nivs.all.di_hilt_room.Product

@Database(entities = [Product::class], version = 1)
abstract class ModelDB : RoomDatabase() {

    abstract fun getFakerDAO() : ModelDAO

}