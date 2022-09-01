package com.ashr.cleanMvvmSocket.domain.repository

import com.ashr.cleanMvvmSocket.domain.model.ConnectionState
import kotlinx.coroutines.flow.Flow

interface TickerRepository {

    fun observeEvent(): Flow<ConnectionState>

    fun observeTicker(): Flow<ConnectionState>

    fun subscribeTicker()

}