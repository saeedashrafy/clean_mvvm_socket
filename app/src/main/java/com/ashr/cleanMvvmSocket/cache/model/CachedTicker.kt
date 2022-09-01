package com.ashr.cleanMvvmSocket.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticker")
data class CachedTicker(
    @PrimaryKey
    val productId: String,
    val price: String? = null,
    val openPrice: String? = null,
    val volume24: String? = null,
    val low24: String? = null,
    val high24: String? = null,
    val volumeMonth: String? = null
)
