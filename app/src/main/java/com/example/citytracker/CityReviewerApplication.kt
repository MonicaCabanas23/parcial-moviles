package com.example.citytracker

import android.app.Application
import com.example.citytracker.models.data.cities
import com.example.citytracker.repository.CityRepository

class CityReviewerApplication: Application() {
    val cityRepository: CityRepository by lazy {
        CityRepository(cities)
    }
}