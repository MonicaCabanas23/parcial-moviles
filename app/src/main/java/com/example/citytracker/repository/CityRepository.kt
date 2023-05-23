package com.example.citytracker.repository

import com.example.citytracker.models.data.CityModel

class CityRepository(private val cities: MutableList<CityModel>) {
    fun getCities() = cities;
    fun addCity(newCity: CityModel) = cities.add(newCity);
}