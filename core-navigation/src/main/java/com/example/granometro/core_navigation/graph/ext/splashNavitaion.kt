package com.example.granometro.core_navigation.graph.ext

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.granometro.core_navigation.route.NavigationDestinations

fun NavGraphBuilder.splashNavigation(
    splashScreen: @Composable () -> Unit
) {
    composable(NavigationDestinations.Splash.route) {
        splashScreen()
    }
}