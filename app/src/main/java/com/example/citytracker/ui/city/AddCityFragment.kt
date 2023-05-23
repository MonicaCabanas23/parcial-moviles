package com.example.citytracker.ui.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.citytracker.R
import com.example.citytracker.databinding.FragmentAddCityBinding

class AddCityFragment : Fragment() {
    private val cityViewModel: CityViewModel by activityViewModels {
        CityViewModel.Factory
    }

    private lateinit var binding: FragmentAddCityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }
    private fun setViewModel() {
        binding.viewmodel = cityViewModel
    }

    private fun observeStatus() {
        cityViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(CityViewModel.WRONG_INFORMATION) -> {
                    cityViewModel.clearStatus()

                }
                status.equals(  CityViewModel.CITY_CREATED) -> {
                    cityViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}