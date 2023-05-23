package com.example.citytracker.ui.city.cityList.recyclerView

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.citytracker.databinding.CityItemBinding
import com.example.citytracker.models.data.CityModel

class CityRecyclerViewHolder (private val binding: CityItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(city: CityModel, clickListener: (CityModel) -> Unit) {
         binding.nombreTextViewCardView.text = city.nombre

        binding.cityCardView.setOnClickListener{
            clickListener(city)
            Log.d("APP_TAG", city.nombre)
        }
    }
}