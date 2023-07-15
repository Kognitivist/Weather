package com.testtask.lainc.data

import com.testtask.lainc.data.model.City

class RoomRepository(private val dao: DAO)  {

    val getAllCities = dao.getAllCities()

    suspend fun addCity (city: City){
        dao.addCity(city)
    }

    suspend fun deleteCity(city: City){
        dao.deleteCity(city)
    }


}




