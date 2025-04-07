package com.example.multimodule

import androidx.navigation.NavController
import com.example.multimodule.navigation.AppNavigationManager
import com.example.multimodule.navigation.NavControllerProvider
import com.example.navigator.ModuleType
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.reset

class AppNavigationManagerTest {

    private lateinit var navigationController: NavController
    private lateinit var navControllerProvider: NavControllerProvider
    private lateinit var appNavigationManager: AppNavigationManager


    @Before
    fun setUp() {
        navigationController = mock<NavController>()

        navControllerProvider = NavControllerProvider().apply {
            setNavController(navigationController)
        }

        appNavigationManager = AppNavigationManager(navControllerProvider)
    }

    @Test
    fun givenOnboardingModule_whenNavigating_thenNavigatesToOnboardingFragment() {

        //act
        appNavigationManager.navigateToFeatureModule(ModuleType.OnboardingModule)

        // Assert
        verify(navigationController).navigate(R.id.action_module_to_onboarding)
    }

    @After
    fun cleanUp() {
        reset(navigationController)
    }
}