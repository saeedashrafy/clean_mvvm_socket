package com.ashr.cleanMvvmSocket.core.di

import com.ashr.cleanMvvmSocket.core.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Singleton
    @Provides
    fun provideCoroutineDispatcher() = CoroutineDispatcherProvider()

}