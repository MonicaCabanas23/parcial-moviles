package com.example.citytracker.ui.city.cityList.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.citytracker.databinding.CityItemBinding
import com.example.citytracker.models.data.CityModel

class CityRecyclerViewAdapter(
    private val clickListener: (CityModel) -> Unit
) : RecyclerView.Adapter<CityRecyclerViewHolder>()  {
    private val cities = ArrayList<CityModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityRecyclerViewHolder {
        val binding = CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    override fun onBindViewHolder(holder: CityRecyclerViewHolder, position: Int) {
        val movie = cities[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<CityModel>) {
        cities.clear()
        cities.addAll(moviesList)
    }
}