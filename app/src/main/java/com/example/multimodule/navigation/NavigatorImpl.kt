package com.example.multimodule.navigation

import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import com.example.multimodule.R
import com.example.navigator.INavigateTo
import javax.inject.Inject

class NavigatorImpl @Inject constructor(private val navControllerProvider: NavControllerProvider) :
    INavigateTo {
    override fun navigateTo(type: Int) {

        when (type) {
            1 -> {
                navControllerProvider.getNavController()?.navigate(R.id.action_splash_to_login)
            }
            2 -> {
                navControllerProvider.getNavController()?.navigate(R.id.action_splash_to_home)
            }
            3 -> {
                navControllerProvider.getNavController()?.navigate(R.id.action_login_to_home)
            }
            else -> {
                val request =
                    NavDeepLinkRequest.Builder.fromUri("myapp://mission_details".toUri()).build()
                navControllerProvider.getNavController()?.navigate(request)
            }
        }
    }
}