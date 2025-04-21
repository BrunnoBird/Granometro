package com.example.granometro.presentation.screens.home

import java.math.BigDecimal

sealed interface HomeEvent {
    object LoadData : HomeEvent
    data class UpdateMonthValue(val value: BigDecimal) : HomeEvent
    data class UpdateDayValue(val value: BigDecimal) : HomeEvent
    data class UpdateMaxMonthValue(val value: BigDecimal) : HomeEvent
}