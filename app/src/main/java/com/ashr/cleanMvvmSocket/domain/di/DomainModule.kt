package com.ashr.cleanMvvmSocket.domain.di

import com.ashr.cleanMvvmSocket.domain.repository.TickerRepository
import com.ashr.cleanMvvmSocket.domain.usecase.GetTickersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesSetupConnectionUseCase(coinbaseRepository: TickerRepository): GetTickersUseCase =
        GetTickersUseCase(coinbaseRepository)

}