package com.example.granometro.core_navigation.util

import androidx.navigation.NavController

fun NavController.navigateSingleTop(route: String) {
    this.navigate(route) {
        launchSingleTop = true
    }
}