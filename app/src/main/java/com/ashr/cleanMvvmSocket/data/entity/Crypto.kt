package com.ashr.cleanMvvmSocket.data.entity

enum class Crypto(val id: String, val code: String, val fullName: String) {
    BITCOIN(id = "BTC-USD", code = "BTC", fullName = "Bitcoin"),
    ETHEREUM(id = "ETH-USD", code = "ETH", fullName = "Ethereum"),
    CARDANO(id = "ADA-USD", code = "ADA", fullName = "Cardano"),
    CHAINLINK(id = "LINK-USD", code = "LINK", fullName = "Chainlink"),
    LITECOIN(id = "LTC-USD", code = "LTC", fullName = "Litecoin")
}