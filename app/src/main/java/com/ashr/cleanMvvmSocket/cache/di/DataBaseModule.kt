package com.ashr.cleanMvvmSocket.cache.di

import android.content.Context
import androidx.room.Room
import com.ashr.cleanMvvmSocket.cache.db.AppDatabase
import com.ashr.cleanMvvmSocket.cache.db.TickerDao
import com.ashr.cleanMvvmSocket.cache.mapper.TickerEntityMapper
import com.ashr.cleanMvvmSocket.cache.source.TickerCacheDatasourceImpl
import com.ashr.cleanMvvmSocket.data.datasource.cache.TickerCacheDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideVehicleDao(database: AppDatabase): TickerDao =
        database.vehicleDao()


    @Provides
    @Singleton
    fun provideVehicleCacheDatasource(
        veiTickerDao: TickerDao,
        tickerEntityMapper: TickerEntityMapper
    ): TickerCacheDataSource = TickerCacheDatasourceImpl(veiTickerDao, tickerEntityMapper)
}