package com.ashr.cleanMvvmSocket.domain.model

sealed interface ConnectionState {
    object Connected : ConnectionState
    object Disconnected : ConnectionState
    data class Success(val data: Ticker) : ConnectionState
}
