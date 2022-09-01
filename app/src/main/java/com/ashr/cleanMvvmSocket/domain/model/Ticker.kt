package com.ashr.cleanMvvmSocket.domain.model

data class Ticker(
    val productId: String,
    val productCode: String,
    val productName: String,
    val price: Double,
    val openPrice: Double,
    val volume24: Double,
    val low24: Double,
    val high24: Double,
    val volumeMonth: Double
)
