package com.example.onboarding.ui.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.feature.login.R
import com.example.feature.login.databinding.FragmentLoginBinding
import com.example.onboarding.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private val viewModel: LoginViewModel by viewModels()

    private lateinit var binding: FragmentLoginBinding

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI() {
        binding.btnLogin.setOnClickListener {
            viewModel.loginUser("mohit", "12345678")
            // navigator.navigateToFeatureModule(ModuleType.HomeModule)
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
            // navigator.navigateToFeatureModule(ModuleType.HomeModule)
        }
    }
}
