package com.example.multimodule

import androidx.navigation.NavController
import com.example.multimodule.navigation.NavControllerProvider
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.reset

class NavControllerProviderTest {

    private lateinit var mockNavController: NavController
    private lateinit var navControllerProvider: NavControllerProvider

    @Before
    fun setUp() {
        mockNavController = mock<NavController>()
        navControllerProvider = NavControllerProvider()
    }

    @Test
    fun `setNavController should store the navController`() {
        navControllerProvider.setNavController(mockNavController)

        val retrievedController = navControllerProvider.getNavController()

        assertNotNull(retrievedController)
        assertEquals(mockNavController, retrievedController)
    }

    @Test
    fun `getNavController should return null if not set`() {
        val retrievedController = navControllerProvider.getNavController()
        assertNull(retrievedController)
    }

    @After
    fun cleanUp() {
        reset(mockNavController)
    }
}
