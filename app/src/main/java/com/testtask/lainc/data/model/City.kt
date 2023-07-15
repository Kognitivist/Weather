package com.testtask.lainc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Cities")
data class City(
    @PrimaryKey
    val name: String
)