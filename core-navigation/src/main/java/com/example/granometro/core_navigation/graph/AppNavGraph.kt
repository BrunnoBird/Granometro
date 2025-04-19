package com.example.granometro.core_navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.granometro.core_navigation.route.NavigationDestinations
import com.example.granometro.core_navigation.route.NavigationRoutes


//Deixar mais modular este codigo evitando acoplamento, usando Builders:

//@Composable
//fun AppNavGraph(
//    navController: NavHostController,
//    startDestination: String = NavigationDestinations.Home.route,
//    homeScreen: @Composable () -> Unit,
//    signInScreen: @Composable () -> Unit,
//    signUpScreen: @Composable () -> Unit
//) {
//    NavHost(navController = navController, startDestination = startDestination) {
//        homeNavigation(homeScreen)
//        authNavigation(signInScreen, signUpScreen)
//    }
//}


@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = NavigationDestinations.Home.route,
    homeScreen: @Composable () -> Unit,
    signInScreen: @Composable () -> Unit,
    signUpScreen: @Composable () -> Unit
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationRoutes.Home) {
            homeScreen()
        }

        composable(NavigationRoutes.SignIn) {
            signInScreen()
        }

        composable(NavigationRoutes.SignUp) {
            signUpScreen()
        }
    }
}