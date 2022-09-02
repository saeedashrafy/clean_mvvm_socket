package com.ashr.cleanMvvmSocket.data.repository

import com.ashr.cleanMvvmSocket.data.datasource.cache.TickerCacheDataSource
import com.ashr.cleanMvvmSocket.data.datasource.remote.TickerRemoteDataSource
import com.ashr.cleanMvvmSocket.data.entity.Crypto
import com.ashr.cleanMvvmSocket.data.mapper.TickerMapper
import com.ashr.cleanMvvmSocket.domain.model.ConnectionState
import com.ashr.cleanMvvmSocket.domain.repository.TickerRepository
import com.ashr.cleanMvvmSocket.remote.model.Subscribe
import com.tinder.scarlet.WebSocket
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TickerRepositoryImpl @Inject constructor(
    private val tickerRemoteDataSource: TickerRemoteDataSource,
    private val tickerCacheDataSource: TickerCacheDataSource,
    private val tickerMapper: TickerMapper,
) : TickerRepository {

    override fun observeEvent(): Flow<ConnectionState> {

        return tickerRemoteDataSource.observeEvent()
            .map { event ->
                when (event) {
                    is WebSocket.Event.OnConnectionOpened<*> -> {
                        subscribeTicker()
                        ConnectionState.Connected
                    }
                    is WebSocket.Event.OnMessageReceived -> {
                        ConnectionState.Connected
                    }
                    else -> {
                        ConnectionState.Disconnected
                    }
                }
            }
    }

    override fun observeTicker(): Flow<ConnectionState> = flow {
        tickerCacheDataSource.getAllTicker()
            .map { tickerMapper.mapFromEntity(it) }
            .onEach {
                emit(ConnectionState.Success(it))
            }
        emitAll(tickerRemoteDataSource.observeTicker()
            .onEach { tickerEntity ->
                tickerCacheDataSource.upsertTicker(tickerEntity)
            }
            .map
            {
                ConnectionState.Success(tickerMapper.mapFromEntity(it))
            })
    }

    override fun subscribeTicker() {
        tickerRemoteDataSource.sendSubscribe(
            Subscribe(
                productIds = Crypto.values()
                    .map { it.id },
                channels = listOf("ticker")
            )
        )
    }

}