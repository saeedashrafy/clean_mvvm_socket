package com.ashr.cleanMvvmSocket.data.entity

data class TickerEntity(
    val productId: String? = null,
    val price: String? = null,
    val openPrice: String? = null,
    val volume24: String? = null,
    val low24: String? = null,
    val high24: String? = null,
    val volumeMonth: String? = null
)
