package com.ashr.cleanMvvmSocket.data.di

import com.ashr.cleanMvvmSocket.core.CoroutineDispatcherProvider
import com.ashr.cleanMvvmSocket.data.datasource.cache.TickerCacheDataSource
import com.ashr.cleanMvvmSocket.data.datasource.remote.TickerRemoteDataSource
import com.ashr.cleanMvvmSocket.data.mapper.TickerMapper
import com.ashr.cleanMvvmSocket.data.repository.TickerRepositoryImpl
import com.ashr.cleanMvvmSocket.domain.repository.TickerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideVehicleMapper(): TickerMapper = TickerMapper()


    @Provides
    @Singleton
    fun providesCoinbaseRepository(
        tickerRemoteDataSource: TickerRemoteDataSource,
        tickerCacheDataSource: TickerCacheDataSource,
        tickerMapper: TickerMapper,
        dispatcherProvider: CoroutineDispatcherProvider
    ): TickerRepository =
        TickerRepositoryImpl(tickerRemoteDataSource,tickerCacheDataSource,tickerMapper,dispatcherProvider)
}