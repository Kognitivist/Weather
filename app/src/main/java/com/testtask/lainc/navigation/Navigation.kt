package com.testtask.lainc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.testtask.lainc.presentation.MyViewModel
import com.testtask.lainc.presentation.SettingScreen
import com.testtask.lainc.presentation.StartScreen

sealed class AllScreens(val route: String) {
    object StartScreens : AllScreens("StartScreen")
    object SettingScreens : AllScreens("SettingScreen")
}

@Composable
fun StartApp(
    navigator: NavHostController,
    viewModel: MyViewModel
) {
    NavHost(navController = navigator, startDestination = AllScreens.StartScreens.route) {
        composable(AllScreens.StartScreens.route) {
            StartScreen(navigator, viewModel)
        }
        composable(AllScreens.SettingScreens.route) {
            SettingScreen(viewModel)
        }
    }
}