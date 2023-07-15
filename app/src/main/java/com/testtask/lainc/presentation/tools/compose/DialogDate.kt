package com.testtask.lainc.presentation.tools.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.testtask.lainc.presentation.MyViewModel
import com.testtask.lainc.presentation.tools.extension.toDate
import com.testtask.lainc.tools.`fun`.getDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogDate (openDialog: MutableState<Boolean>, viewModel: MyViewModel) {


    DatePickerDialog(
        onDismissRequest = { openDialog.value = false },
        confirmButton = {}
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardDate(dayNumber = 0, viewModel, openDialog)
            CardDate(dayNumber = 1, viewModel, openDialog)
            CardDate(dayNumber = 2, viewModel, openDialog)
        }
    }
}