package com.example.multimodule

import androidx.navigation.NavController
import com.example.multimodule.navigation.AppNavigationManager
import com.example.multimodule.navigation.NavControllerProvider
import com.example.navigator.ModuleType
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.never
import org.mockito.kotlin.reset

class AppNavigationManagerTest {

    private lateinit var mockNavController: NavController
    private lateinit var navControllerProvider: NavControllerProvider
    private lateinit var appNavigationManager: AppNavigationManager

    @Before
    fun setUp() {
        mockNavController = mock<NavController>()

        navControllerProvider = NavControllerProvider().apply {
            setNavController(mockNavController)
        }

        appNavigationManager = AppNavigationManager(navControllerProvider)
    }

    @Test
    fun givenOnboardingModule_whenNavigating_thenNavigatesToOnboardingModule() {
        appNavigationManager.navigateToFeatureModule(ModuleType.OnboardingModule)

        verify(mockNavController).navigate(R.id.action_module_to_onboarding)
        verify(mockNavController, never()).navigate(R.id.action_module_to_home)
    }

    @Test
    fun whenNavControllerNull_shouldNotNavigateToOnboardingModule() {
        navControllerProvider.setNavController(null)

        appNavigationManager.navigateToFeatureModule(ModuleType.OnboardingModule)

        verify(mockNavController, never()).navigate(anyInt())
    }

    @Test
    fun givenHomeModule_whenNavigating_thenNavigatesToHomeModule() {
        appNavigationManager.navigateToFeatureModule(ModuleType.HomeModule)

        verify(mockNavController).navigate(R.id.action_module_to_home)
        verify(mockNavController, never()).navigate(R.id.action_module_to_onboarding)
    }

    @Test
    fun whenNavControllerNull_shouldNotNavigateToHomeModule() {
        navControllerProvider.setNavController(null)

        appNavigationManager.navigateToFeatureModule(ModuleType.HomeModule)

        verify(mockNavController, never()).navigate(anyInt())
    }

    @Test
    fun whenNothing(){
        appNavigationManager.navigateToFeatureModule(ModuleType.None)
        verify(mockNavController, never()).navigate(R.id.action_module_to_onboarding)
        verify(mockNavController, never()).navigate(R.id.action_module_to_home)
    }

    @After
    fun cleanUp() {
        reset(mockNavController)
    }
}
