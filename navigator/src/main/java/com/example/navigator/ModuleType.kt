package com.example.navigator

sealed interface ModuleType {
    data object OnboardingModule : ModuleType
    data object HomeModule : ModuleType
}
