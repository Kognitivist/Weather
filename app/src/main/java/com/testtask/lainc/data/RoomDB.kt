package com.testtask.lainc.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.testtask.lainc.data.DAO
import com.testtask.lainc.data.model.City

@Database(entities = [City::class], version = 1)
abstract class RoomDB: RoomDatabase() {
    abstract fun getRoomDao(): DAO
}