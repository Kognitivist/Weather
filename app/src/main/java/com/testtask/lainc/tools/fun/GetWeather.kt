package com.testtask.lainc.tools.`fun`


import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.testtask.lainc.data.model.Weather
import com.testtask.lainc.presentation.MyViewModel
import com.testtask.lainc.tools.Constants.Companion.API_KEY
import org.json.JSONObject

fun getWeather(context: Context ,city:String, date:String, viewModel: MyViewModel)/*:Weather?*/{
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY&q=$city&days=3&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { string ->
            val json = JSONObject(string)
            Log.d("MyLog", "$json")
            when(date){
                getDate(0) ->{
                    val dateForecast = json
                        .getJSONObject("forecast")
                        .getJSONArray("forecastday")
                        .getJSONObject(0)
                        .getJSONObject("day")
                    val temp = dateForecast.getString("avgtemp_c")
                    val precipitation = dateForecast
                        .getJSONObject("condition").getString("text")
                    viewModel.changeWeatherFieldField(Weather(temp = temp, precipitation = precipitation))

                }
                getDate(1) ->{
                    val dateForecast = json
                        .getJSONObject("forecast")
                        .getJSONArray("forecastday")
                        .getJSONObject(1)
                        .getJSONObject("day")
                    val temp = dateForecast.getString("avgtemp_c")
                    val precipitation = dateForecast
                        .getJSONObject("condition").getString("text")
                    viewModel.changeWeatherFieldField(Weather(temp = temp, precipitation = precipitation))
                }
                getDate(2) ->{
                    val dateForecast = json
                        .getJSONObject("forecast")
                        .getJSONArray("forecastday")
                        .getJSONObject(2)
                        .getJSONObject("day")
                    val temp = dateForecast.getString("avgtemp_c")
                    val precipitation = dateForecast
                        .getJSONObject("condition").getString("text")
                    viewModel.changeWeatherFieldField(Weather(temp = temp, precipitation = precipitation))
                }
                else -> {
                    Toast.makeText(context, "Некорректная дата", Toast.LENGTH_SHORT).show()
                    viewModel.changeWeatherFieldField(Weather())
                }
            }


        },
        {
            Toast.makeText(context, "Некорректная дата или город", Toast.LENGTH_SHORT).show()
            viewModel.changeWeatherFieldField(Weather())
            Log.d("myTag", "$it")
        }
    )


    queue.add(stringRequest)

}