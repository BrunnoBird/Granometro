package com.example.granometro.core_navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.granometro.core_navigation.graph.ext.homeNavigation
import com.example.granometro.core_navigation.graph.ext.signInNavigation
import com.example.granometro.core_navigation.graph.ext.signUpNavigation
import com.example.granometro.core_navigation.graph.ext.splashNavigation
import com.example.granometro.core_navigation.route.NavigationDestinations

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = NavigationDestinations.Splash.route,
    splashScreen: @Composable () -> Unit,
    homeScreen: @Composable () -> Unit,
    signInScreen: @Composable () -> Unit,
    signUpScreen: @Composable () -> Unit
) {
    NavHost(navController = navController, startDestination = startDestination) {
        splashNavigation(splashScreen)
        homeNavigation(homeScreen)
        signInNavigation(signInScreen)
        signUpNavigation(signUpScreen)
    }
}