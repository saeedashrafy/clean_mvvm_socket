package com.ashr.cleanMvvmSocket.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteTicker(
    @Json(name = "product_id")
    val productId: String,
    val price: String?,
    @Json(name = "open_24h")
    val openPrice: String?,
    @Json(name = "volume_24h")
    val volume24: String?,
    @Json(name = "low_24h")
    val low24: String?,
    @Json(name = "high_24h")
    val high24: String?,
    @Json(name = "volume_30d")
    val volume30d: String?,
)