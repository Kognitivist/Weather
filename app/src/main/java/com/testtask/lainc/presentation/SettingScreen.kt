package com.testtask.lainc.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.testtask.lainc.data.model.City

@Composable
fun SettingScreen (viewModel: MyViewModel) {

    val listCity = viewModel.getAllCities.observeAsState(listOf()).value
    val text = remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value){
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Выберите город")
                }
            },
            text = {
                   Row(
                       modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.Center,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       OutlinedTextField(value = text.value, onValueChange = {text.value = it})
                   }
            },
            confirmButton = {
                Button(onClick = {
                    viewModel.addCity(City(name = text.value))
                    openDialog.value = false
                }) {
                    Text(text = "Добавить город")
                }
            }
        )
    }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = { openDialog.value = true}) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            }
        }
            ){
        LazyColumn(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxWidth(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(listCity){
                Spacer(modifier = Modifier.size(20.dp))
                Card(modifier = Modifier.fillMaxWidth(0.8f)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(vertical = 5.dp, horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(text = it.name)
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "delete",
                            modifier = Modifier.clickable { viewModel.deleteCity(it) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SettingScreenPreview () {
    val viewModel = viewModel(modelClass = MyViewModel::class.java)
    SettingScreen(viewModel)
}