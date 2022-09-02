package com.ashr.cleanMvvmSocket.data.mapper

import com.ashr.cleanMvvmSocket.data.entity.Crypto
import com.ashr.cleanMvvmSocket.data.entity.TickerEntity
import com.ashr.cleanMvvmSocket.domain.model.Ticker
import javax.inject.Inject

class TickerMapper @Inject constructor() : Mapper<TickerEntity, Ticker> {

    override fun mapFromEntity(entity: TickerEntity): Ticker {
        val enum = Crypto.values().find { crypto -> crypto.id == entity.productId }
        return Ticker(
            productId = entity.productId ?: "",
            productCode = enum?.code
                ?: "",
            productName = enum?.fullName
                ?: "",
            price = entity.price?.toDouble() ?: 0.0,
            openPrice = entity.openPrice?.toDouble() ?: 0.0,
            volume24 = entity.volume24?.toDouble() ?: 0.0,
            low24 = entity.low24?.toDouble() ?: 0.0,
            high24 = entity.high24?.toDouble() ?: 0.0,
            volumeMonth = entity.volumeMonth?.toDouble() ?: 0.0,
        )
    }

    override fun mapToEntity(domainModel: Ticker): TickerEntity {
        return TickerEntity()
    }
}