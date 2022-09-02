package com.ashr.cleanMvvmSocket.core.di.module

import com.ashr.cleanMvvmSocket.core.di.annotation.HiltDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

   @HiltDispatchers.Main
   @Singleton
   @Provides
    fun provideDispatcherMain(): CoroutineDispatcher = Dispatchers.Main


    @HiltDispatchers.IO
    @Singleton
    @Provides
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO


    @HiltDispatchers.Default
    @Singleton
    @Provides
    fun provideDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

}