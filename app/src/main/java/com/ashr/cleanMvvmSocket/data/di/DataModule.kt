package com.ashr.cleanMvvmSocket.data.di

import com.ashr.cleanMvvmSocket.data.repository.TickerRepositoryImpl
import com.ashr.cleanMvvmSocket.domain.repository.TickerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsCoinbaseRepository(tickerRepositoryImpl: TickerRepositoryImpl): TickerRepository
}