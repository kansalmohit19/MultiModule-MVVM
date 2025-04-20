package com.example.splash.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.common.Constants.DELAY_3000
import com.example.feature.splash.databinding.FragmentSplashBinding
import com.example.navigator.ModuleType
import com.example.splash.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SplashFragment : BaseFragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun bindView(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI() {
        lifecycleScope.launch(Dispatchers.IO) {
            delay(DELAY_3000.toLong())
            withContext(Dispatchers.Main) {
                navigator.navigateToFeatureModule(ModuleType.OnboardingModule)
            }
        }
    }
}
