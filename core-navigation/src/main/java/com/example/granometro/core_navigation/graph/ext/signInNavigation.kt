package com.example.granometro.core_navigation.graph.ext

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.granometro.core_navigation.route.NavigationDestinations

fun NavGraphBuilder.signInNavigation(
    signInScreen: @Composable () -> Unit
) {
    composable(NavigationDestinations.SignIn.route) {
        signInScreen()
    }
}