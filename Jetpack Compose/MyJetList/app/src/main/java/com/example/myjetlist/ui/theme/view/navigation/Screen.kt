package com.example.myjetlist.ui.theme.view.navigation

sealed class Screen(val route: String) {
    object Home : Screen("jetCarsApp")
    object Profile : Screen("ProfileScreen")
    object Detail : Screen("DetailScreen")
}