package com.ashr.cleanMvvmSocket.core.di

import com.ashr.cleanMvvmSocket.core.DispatcherProvider
import com.ashr.cleanMvvmSocket.core.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DispatchersModule {

    @Binds
    fun bindsCoroutineDispatcher(dispatcherProviderImpl: DispatcherProviderImpl): DispatcherProvider

}