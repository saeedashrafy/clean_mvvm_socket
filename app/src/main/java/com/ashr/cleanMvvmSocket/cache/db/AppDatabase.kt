package com.ashr.cleanMvvmSocket.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ashr.cleanMvvmSocket.cache.model.CachedTicker

@Database(entities = [CachedTicker::class], version = 1)
@TypeConverters(Convertors::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun vehicleDao(): TickerDao

    companion object {
        const val DATABASE_NAME = "clean_mvvm_socket"
    }
}