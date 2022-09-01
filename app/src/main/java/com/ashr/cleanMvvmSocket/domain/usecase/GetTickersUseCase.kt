package com.ashr.cleanMvvmSocket.domain.usecase

import com.ashr.cleanMvvmSocket.domain.repository.TickerRepository
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class GetTickersUseCase @Inject constructor(private val coinbaseRepository: TickerRepository) {
    operator fun invoke() =
        merge(coinbaseRepository.observeTicker(), coinbaseRepository.observeEvent())
}