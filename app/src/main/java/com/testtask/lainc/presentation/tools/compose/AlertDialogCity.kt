package com.testtask.lainc.presentation.tools.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.testtask.lainc.data.model.City
import com.testtask.lainc.presentation.MyViewModel

@Composable
fun AlertDialogCity(
    openDialog:MutableState<Boolean>,
    viewModel: MyViewModel
) {

    val listCity:List<City> = viewModel.getAllCities.observeAsState(listOf()).value

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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                items(listCity) {
                    Spacer(modifier = Modifier.size(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                viewModel.changeTextCityField(it)
                                openDialog.value = false
                            },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = it.name)
                    }
                }
            }
        },
        confirmButton = {},
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.7f)
    )
}