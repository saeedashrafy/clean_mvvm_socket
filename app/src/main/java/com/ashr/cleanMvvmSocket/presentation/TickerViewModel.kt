package com.ashr.cleanMvvmSocket.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashr.cleanMvvmSocket.core.DispatcherProviderImpl
import com.ashr.cleanMvvmSocket.domain.model.ConnectionState
import com.ashr.cleanMvvmSocket.domain.model.Ticker
import com.ashr.cleanMvvmSocket.domain.usecase.GetTickersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TickerViewModel @Inject constructor(
    val getTickersUseCase: GetTickersUseCase,
    private val dispatcherProvider: DispatcherProviderImpl,
) : ViewModel() {

    private val combinedPrices = mutableMapOf<String, Ticker>()

    private val _uiState = MutableStateFlow<TickerUiState>(TickerUiState(data = emptyList()))
    val uiState = _uiState.asStateFlow()

    init {
        Timber.e("Init VM")
    }

    fun getCryptos(productId: String? = null) {
        viewModelScope.launch(dispatcherProvider.io) {
            getTickersUseCase()
                .onStart {
                    _uiState.update { it.copy(isLoading = true) }
                }
                .onEach { event ->
                    when (event) {
                        is ConnectionState.Connected -> {
                            _uiState.update {
                                it.copy(isLoading = false, isOnline = true)
                            }
                        }
                        is ConnectionState.Success -> {
                            combinedPrices[event.data.productId] = event.data
                            //    Timber.e(combinedPrices.values.toString())
                            _uiState.update { tickerState ->
                                val list = if (productId != null) {
                                    combinedPrices.values.filter { ticker -> ticker.productId == productId }
                                        .toList()
                                } else combinedPrices.values.toList()

                                Timber.e(list.toString())
                                tickerState.copy(data = list)
                            }

                        }
                        else -> {
                            _uiState.update {
                                it.copy(isLoading = false, isOnline = false)
                            }
                        }
                    }
                }.collect()
        }
    }

}


data class TickerUiState(
    val data: List<Ticker>,
    val isLoading: Boolean = true,
    val isOnline: Boolean = false,
    val error: String = ""
)
