package com.example.home.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature.home.databinding.FragmentListBinding
import com.example.home.BaseFragment
import com.example.navigator.ModuleType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment() {
    private lateinit var binding: FragmentListBinding

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI() {
        binding.listBtnDetails.setOnClickListener {
            navigator.navigateToFeatureModule(ModuleType.HomeModule)
        }
    }
}