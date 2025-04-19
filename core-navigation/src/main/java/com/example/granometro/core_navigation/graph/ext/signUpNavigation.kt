package com.example.granometro.core_navigation.graph.ext

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.granometro.core_navigation.route.NavigationDestinations

fun NavGraphBuilder.signUpNavigation(
    signUpScreen: @Composable () ->Unit
) {
    composable(NavigationDestinations.SignUp.route) {
        signUpScreen()
    }
}