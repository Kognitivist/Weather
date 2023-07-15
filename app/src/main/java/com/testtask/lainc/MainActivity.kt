package com.testtask.lainc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.testtask.lainc.data.RoomDB
import com.testtask.lainc.data.RoomRepository
import com.testtask.lainc.data.model.Weather
import com.testtask.lainc.navigation.StartApp
import com.testtask.lainc.presentation.MyViewModel
import com.testtask.lainc.presentation.MyViewModelFactory
import com.testtask.lainc.tools.`fun`.getWeather
import com.testtask.lainc.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navigator = rememberNavController()
            val database = Room
                .databaseBuilder(context = this, klass = RoomDB::class.java, name = "Database")
                .build()
            val dao = database.getRoomDao()
            val repository = RoomRepository(dao)
            val viewModel:MyViewModel = viewModel(factory = MyViewModelFactory(repository = repository))
            viewModel.initialStartValuesDB()




            WeatherTheme {
                StartApp(navigator = navigator, viewModel = viewModel)
            }
        }
    }
}
