package com.example.citytracker.ui.city.cityList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.citytracker.R
import com.example.citytracker.databinding.FragmentCityListBinding
import com.example.citytracker.models.data.CityModel
import com.example.citytracker.ui.city.CityViewModel
import com.example.citytracker.ui.city.cityList.recyclerView.CityRecyclerViewAdapter

class CityListFragment : Fragment() {

    private val viewModel: CityViewModel by activityViewModels {
        CityViewModel.Factory
    }

    private lateinit var adapter: CityRecyclerViewAdapter
    private lateinit var binding: FragmentCityListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCityListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()

        binding.floatingActionButton.setOnClickListener{
            viewModel.clearData()
            findNavController().navigate(R.id.action_cityListFragment_to_addCityFragment)
        }
    }

    private fun setRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(view?.context)

        adapter = CityRecyclerViewAdapter { selectedCity ->
            showSelectedItem(selectedCity)
        }

        binding.recyclerView.adapter = adapter
        displayCities()
    }

    private fun displayCities() {
        adapter.setData(viewModel.getCities())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(selectedCity: CityModel) {
        viewModel.setSelectedCity(selectedCity)
        findNavController().navigate(R.id.action_cityListFragment_to_cityFragment)
    }
}