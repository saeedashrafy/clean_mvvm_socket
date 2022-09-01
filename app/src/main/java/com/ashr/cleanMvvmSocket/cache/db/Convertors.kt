package com.ashr.cleanMvvmSocket.cache.db

import androidx.room.TypeConverter
import java.util.*

class Convertors {
    @TypeConverter
    fun fromTimeStamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(value: Date?): Long? {
        return value?.let { value.time }
    }
}