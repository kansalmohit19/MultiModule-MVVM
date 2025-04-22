package com.example.multimodule.navigation

import androidx.navigation.NavController
import javax.inject.Inject

class NavControllerProvider @Inject constructor() {
    private var navController: NavController? = null

    fun setNavController(navController: NavController?) {
        this.navController = navController
    }

    fun getNavController(): NavController? {
        return navController
    }
}
