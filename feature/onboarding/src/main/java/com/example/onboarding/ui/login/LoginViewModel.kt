package com.example.onboarding.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import android.util.Log
import com.example.domain.usecase.auth.LoginRequest
import com.example.domain.usecase.auth.LoginUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUserUseCase: LoginUserUseCase) :
    ViewModel() {

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            loginUserUseCase.invoke(
                scope = viewModelScope,
                params = LoginRequest(username, password),
                onSuccess = {
                    Log.e("Test", "Success")
                },
                onFailure = {
                    Log.e("Test", "Failure")
                }
            )
        }
    }
}
