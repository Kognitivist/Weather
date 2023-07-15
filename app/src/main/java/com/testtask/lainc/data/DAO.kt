package com.testtask.lainc.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.testtask.lainc.data.model.City

@Dao
interface DAO {

    @Query("SELECT * FROM Cities")
    fun getAllCities(): LiveData<List<City>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCity(city: City)

    @Delete
    suspend fun deleteCity(city: City)


}