package com.ashr.cleanMvvmSocket.remote.mapper

import com.ashr.cleanMvvmSocket.data.entity.TickerEntity
import com.ashr.cleanMvvmSocket.remote.model.RemoteTicker

class TickerEntityMapper : EntityMapper<RemoteTicker, TickerEntity> {

    override fun mapFromRemote(type: RemoteTicker): TickerEntity {
        return TickerEntity(
            productId = type.productId,
            price = type.price,
            openPrice = type.openPrice,
            volume24 = type.volume24,
            volumeMonth = type.volume30d,
            low24 = type.low24,
            high24 = type.high24
        )
    }
}