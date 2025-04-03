package com.example.home.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature.home.databinding.FragmentDetailsBinding
import com.example.home.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment() {
    private lateinit var binding: FragmentDetailsBinding

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI() {

    }


}