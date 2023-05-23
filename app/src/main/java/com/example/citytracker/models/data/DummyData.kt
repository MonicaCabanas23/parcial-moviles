package com.example.citytracker.models.data

val nombre1 = "Hamburgo"
val poblacion1 = "60000"

val nombre2 = "San Salvador"
val poblacion2 = "20000"


val cities = mutableListOf<CityModel>(
    CityModel(nombre1, poblacion1),
    CityModel(nombre2, poblacion2)
)