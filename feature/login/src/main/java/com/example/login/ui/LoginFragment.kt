package com.example.login.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature.login.databinding.FragmentLoginBinding
import com.example.login.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI() {
        binding.btnHome.setOnClickListener {
            navigator.navigateTo(3)
        }
    }
}