package com.testtask.lainc.tools.`fun`

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun getDate(dayNumber:Long): String {
    val currentDate = LocalDate.now().plusDays(dayNumber)
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return currentDate.format(formatter)
}