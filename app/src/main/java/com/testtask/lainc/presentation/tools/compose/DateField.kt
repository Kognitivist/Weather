package com.testtask.lainc.presentation.tools.compose


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.testtask.lainc.presentation.MyViewModel


@Composable
fun DateField (viewModel: MyViewModel){

    val text = remember { mutableStateOf("") }
    text.value = viewModel.textDateField.observeAsState("").value

    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value){
        DialogDate(openDialog, viewModel)
    }

    OutlinedTextField(
        value = text.value,
        onValueChange = {},
        readOnly = true,
        trailingIcon = {
            IconButton(
                onClick = { openDialog.value = true }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = ""
                )
            }
        },
        label = { Text(text = "Date") }
    )

}

