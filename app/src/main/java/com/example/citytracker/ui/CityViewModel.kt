package com.example.citytracker.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.citytracker.CityReviewerApplication
import com.example.citytracker.models.data.CityModel
import com.example.citytracker.repository.CityRepository

class CityViewModel(private val repository: CityRepository): ViewModel() {
    var nombre = MutableLiveData("")
    var poblacion = MutableLiveData("")
    var status =    MutableLiveData("")

    fun getCities() = repository.getCities()
    fun addCity(newCity: CityModel) = repository.addCity(newCity)

    fun validateData(): Boolean{
        when {
            nombre.value.isNullOrEmpty() -> return false
            poblacion.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createCity() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val city =  CityModel(
            nombre.value.toString(),
            poblacion.value.toString(),
        )

        addCity(city)
        clearData()

        status.value = CITY_CREATED
    }

    fun clearData() {
        nombre.value = ""
        poblacion.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedCity(city: CityModel) {
        nombre.value = city.nombre
        poblacion.value = city.poblacion
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CityReviewerApplication
                CityViewModel(app.cityRepository)
            }
        }

        const val CITY_CREATED = "City created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}