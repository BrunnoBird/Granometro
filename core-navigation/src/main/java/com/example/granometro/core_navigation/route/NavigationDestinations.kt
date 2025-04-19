package com.example.granometro.core_navigation.route

sealed class NavigationDestinations(val route: String) {
    object Home : NavigationDestinations("home")
    object SignIn : NavigationDestinations("signIn")
    object SignUp : NavigationDestinations("signUp")
}