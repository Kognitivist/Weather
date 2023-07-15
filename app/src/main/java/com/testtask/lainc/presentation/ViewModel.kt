package com.testtask.lainc.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.testtask.lainc.data.RoomRepository
import com.testtask.lainc.data.model.City
import com.testtask.lainc.data.model.Weather
import com.testtask.lainc.tools.`fun`.getDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(private val repository: RoomRepository):ViewModel() {


    private val _textCityField:MutableLiveData<String> = MutableLiveData("Moscow")
    val textCityField:LiveData<String> = _textCityField
    fun changeTextCityField(newCity: City){
        _textCityField.value = newCity.name
    }

    private val _textDateField:MutableLiveData<String> = MutableLiveData(getDate(0))
    val textDateField:LiveData<String> = _textDateField
    fun changeTextDateField(newDate: String){
        _textDateField.value = newDate
    }

    private val _weatherField:MutableLiveData<Weather> = MutableLiveData(Weather())
    val weatherField:LiveData<Weather> = _weatherField
    fun changeWeatherFieldField(newWeather: Weather){
        _weatherField.value = newWeather
    }

    val getAllCities = repository.getAllCities

    fun addCity(city: City){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addCity(city)
        }
    }
    fun deleteCity(city: City){
        viewModelScope.launch (Dispatchers.IO) {
            repository.deleteCity(city)
        }
    }

    private val baseValueDB = listOf(City(name = "Moscow"),City(name = "London"),City(name = "New York"))
    fun initialStartValuesDB(){
        viewModelScope.launch (Dispatchers.IO){
            baseValueDB.forEach{
                repository.addCity(it)
            }
        }
    }




}

class MyViewModelFactory(private val repository: RoomRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MyViewModel::class.java)){
            return MyViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}