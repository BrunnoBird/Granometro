package com.example.granometro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.granometro.core_navigation.graph.AppNavGraph
import com.example.granometro.core_navigation.route.NavigationDestinations
import com.example.granometro.core_navigation.util.navigateSingleTop
import com.example.granometro.core_ui.GranometroTheme
import com.example.granometro.presentation.screens.HomeScreen
import com.example.granometro.presentation.screens.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GranometroTheme {
                val navController = rememberNavController()

                AppNavGraph(
                    navController = navController,
                    splashScreen = {
                        SplashScreen {
                            navController.navigateSingleTop(NavigationDestinations.Home.route)
                        }
                    },
                    homeScreen = {
                        HomeScreen(navController)
                    },
                    signInScreen = {},
                    signUpScreen = {}
                )
            }
        }
    }
}
