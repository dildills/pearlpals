package com.example.dilaproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dilaproject.screens.HomeScreen
import com.example.dilaproject.screens.ProfileScreen
import com.example.dilaproject.screens.SkincareScreen

@Composable
fun PearlpalsNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("skincare") { SkincareScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
    }
}