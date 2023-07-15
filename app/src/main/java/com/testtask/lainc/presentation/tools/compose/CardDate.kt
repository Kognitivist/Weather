package com.testtask.lainc.presentation.tools.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.testtask.lainc.presentation.MyViewModel
import com.testtask.lainc.tools.`fun`.getDate

@Composable
fun CardDate(dayNumber:Long, viewModel: MyViewModel, openDialog: MutableState<Boolean>) {

    Card(modifier = Modifier.padding(10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .clickable {
                    viewModel.changeTextDateField(getDate(dayNumber))
                    openDialog.value = false
                           },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = getDate(dayNumber))
        }
    }
    Spacer(modifier = Modifier.size(10.dp))
}