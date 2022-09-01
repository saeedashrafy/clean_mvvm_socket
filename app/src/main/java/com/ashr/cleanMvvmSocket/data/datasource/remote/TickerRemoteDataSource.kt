package com.ashr.cleanMvvmSocket.data.datasource.remote

import com.ashr.cleanMvvmSocket.data.entity.TickerEntity
import com.ashr.cleanMvvmSocket.remote.model.Subscribe
import com.tinder.scarlet.WebSocket
import kotlinx.coroutines.flow.Flow

interface TickerRemoteDataSource {

    fun observeTicker(): Flow<TickerEntity>

    fun sendSubscribe(subscribe: Subscribe)

    fun observeEvent(): Flow<WebSocket.Event>
}