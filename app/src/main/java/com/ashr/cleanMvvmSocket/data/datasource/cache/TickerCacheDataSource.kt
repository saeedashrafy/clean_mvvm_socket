package com.ashr.cleanMvvmSocket.data.datasource.cache

import com.ashr.cleanMvvmSocket.data.entity.TickerEntity

interface TickerCacheDataSource {

   suspend fun getAllTicker():List<TickerEntity>

    suspend fun upsertTicker(tickerEntity: TickerEntity)
}