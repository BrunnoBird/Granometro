package com.example.granometro.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.math.BigDecimal

data class HomeUiState(
    val isLoading: Boolean = false,
    val maxMonthExpense: BigDecimal = BigDecimal.ZERO,
    val idealDayLimit: BigDecimal = BigDecimal.ZERO,
    val dayRemaining: BigDecimal = BigDecimal.ZERO,
    val monthRemaining: BigDecimal = BigDecimal.ZERO
)

class HomeViewModel() : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set


    fun handleEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.LoadData -> loadData()
            is HomeEvent.UpdateDayValue -> updateDayValue(event.value)
            is HomeEvent.UpdateMonthValue -> updateMonthValue(event.value)
            is HomeEvent.UpdateMaxMonthValue -> updateMaxMonthValue(event.value)
        }
    }

    private fun updateMaxMonthValue(value: BigDecimal) {
    }

    private fun updateMonthValue(value: BigDecimal) {

    }

    private fun updateDayValue(value: BigDecimal) {
    }

    private fun loadData() {
        viewModelScope.launch {

        }
    }
}
