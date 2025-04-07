package com.example.onboarding.ui.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature.login.databinding.FragmentRegisterBinding
import com.example.onboarding.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI() {
    }
}