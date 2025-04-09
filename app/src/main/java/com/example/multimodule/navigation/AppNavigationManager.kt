package com.example.multimodule.navigation

import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import com.example.multimodule.R
import com.example.navigator.ModuleType
import com.example.navigator.NavigationManager
import javax.inject.Inject

class AppNavigationManager @Inject constructor(
    private val navControllerProvider: NavControllerProvider
) : NavigationManager {
    override fun navigateToFeatureModule(moduleType: ModuleType) {
        when (moduleType) {
            is ModuleType.OnboardingModule -> {
                navControllerProvider.getNavController()?.navigate(R.id.action_module_to_onboarding)
            }

            is ModuleType.HomeModule -> {
                navControllerProvider.getNavController()?.navigate(R.id.action_module_to_home)
            }

            else -> {
                val request =
                    NavDeepLinkRequest.Builder.fromUri("myapp://mission_details".toUri()).build()
                navControllerProvider.getNavController()?.navigate(request)
            }
        }
    }
}
