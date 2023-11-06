package com.nivs.all.room_offline_crud_notes

import androidx.room.TypeConverter
import java.util.*

class NoteConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}