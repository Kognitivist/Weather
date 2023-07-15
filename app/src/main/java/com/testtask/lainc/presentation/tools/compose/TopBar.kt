package com.testtask.lainc.presentation.tools.compose

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.testtask.lainc.navigation.AllScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar (navigator: NavHostController){
    CenterAlignedTopAppBar(
        title = { Text(text = "Weather") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Setting",
                modifier = Modifier.clickable {
                    navigator.navigate(AllScreens.SettingScreens.route)
                }
            )
        }
    )
}