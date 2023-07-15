package com.testtask.lainc.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.testtask.lainc.data.model.Weather
import com.testtask.lainc.presentation.tools.compose.CityField
import com.testtask.lainc.presentation.tools.compose.DateField
import com.testtask.lainc.presentation.tools.compose.TopBar
import com.testtask.lainc.presentation.tools.compose.WeatherRow
import com.testtask.lainc.tools.`fun`.getWeather
import kotlinx.coroutines.launch

@Composable

fun StartScreen(navigator: NavHostController, viewModel: MyViewModel) {

    val context = LocalContext.current

    val weather = remember { mutableStateOf(Weather()) }
    weather.value = viewModel.weatherField.observeAsState(Weather()).value

    val city = viewModel.textCityField.observeAsState("Moscow").value
    val date = viewModel.textDateField.observeAsState("").value
    LaunchedEffect(key1 = city, key2 = date ){
        getWeather(context, city, date, viewModel)
    }


    Scaffold(
        topBar = { TopBar(navigator) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(top = it.calculateTopPadding()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CityField(viewModel)
            Spacer(modifier = Modifier.size(20.dp))
            DateField(viewModel)
            Spacer(modifier = Modifier.size(20.dp))
            WeatherRow(text = "Temp: ${weather.value.temp} C")
            Spacer(modifier = Modifier.size(10.dp))
            WeatherRow(text = "Precipitation: ${weather.value.precipitation}")
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun StartScreenPreview() {
    val viewModel = viewModel(modelClass = MyViewModel::class.java)
    val navigator = rememberNavController()
    StartScreen(navigator, viewModel)
}
