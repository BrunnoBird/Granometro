package com.example.granometro.presentation.screens.home.data

import java.math.BigDecimal

object HomeDataStore {
    var maxMonthValue: BigDecimal = BigDecimal.ZERO
    var monthValue: BigDecimal = BigDecimal.ZERO
    var dayValue: BigDecimal = BigDecimal.ZERO

    fun resetValues() {
        maxMonthValue = BigDecimal.ZERO
        monthValue = BigDecimal.ZERO
        dayValue = BigDecimal.ZERO
    }
}