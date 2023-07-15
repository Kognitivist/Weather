package com.testtask.lainc.presentation.tools.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.testtask.lainc.data.model.City
import com.testtask.lainc.presentation.MyViewModel


@Composable
fun CityField(viewModel: MyViewModel) {

    val text = remember { mutableStateOf("") }
    text.value = viewModel.textCityField.observeAsState("").value

    val listCity:List<City> = viewModel.getAllCities.observeAsState(listOf()).value
    if (text.value == ""){
        viewModel.changeTextCityField(listCity.getOrNull(0) ?: City(name = ""))
    }


    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        AlertDialogCity(openDialog, viewModel)
    }


    OutlinedTextField(
        value = text.value,
        onValueChange = {},
        readOnly = true,
        trailingIcon = {
            IconButton(
                onClick = { openDialog.value = !openDialog.value }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = ""
                )
            }
        },
        label = { Text(text = "City")}
    )

}
