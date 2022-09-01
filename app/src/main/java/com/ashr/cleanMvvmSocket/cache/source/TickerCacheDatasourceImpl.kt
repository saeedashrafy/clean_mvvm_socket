package com.ashr.cleanMvvmSocket.cache.source

import com.ashr.cleanMvvmSocket.cache.db.TickerDao
import com.ashr.cleanMvvmSocket.cache.mapper.TickerEntityMapper
import com.ashr.cleanMvvmSocket.data.datasource.cache.TickerCacheDataSource
import com.ashr.cleanMvvmSocket.data.entity.TickerEntity
import javax.inject.Inject

class TickerCacheDatasourceImpl @Inject constructor(
    private val tickerDao: TickerDao,
    private val tickerEntityMapper: TickerEntityMapper
) : TickerCacheDataSource {

    override suspend fun getAllTicker(): List<TickerEntity> {
        return tickerDao.getAllVehicles()
            .map { cachedVehicle ->
                tickerEntityMapper.mapFromCached(
                    cachedVehicle
                )
            }
    }

    override suspend fun upsertTicker(tickerEntity: TickerEntity) {
        tickerDao.updateVehicle(tickerEntityMapper.mapToCached(tickerEntity))
    }


}