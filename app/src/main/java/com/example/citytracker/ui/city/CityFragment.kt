package com.example.citytracker.ui.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.citytracker.R
import com.example.citytracker.databinding.FragmentCityBinding

class CityFragment : Fragment() {

    private val viewModel: CityViewModel by activityViewModels {
        CityViewModel.Factory
    }

    private lateinit var binding: FragmentCityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }
}