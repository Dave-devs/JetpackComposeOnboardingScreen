package com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.util.Routes
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.data.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    // private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    // val isLoading: State<Boolean> = _isLoading

    private val _startAnim: MutableState<Boolean> = mutableStateOf(true)
    val startAnim: State<Boolean> = _startAnim

    private val route = Routes.SPLASH_SCREEN

    private val _startDestination: MutableState<String> = mutableStateOf(route)
    val startDestination: MutableState<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Routes.HOME_SCREEN
                } else {
                    _startDestination.value = Routes.SPLASH_SCREEN
                }
            }
            //_isLoading.value = false
            _startAnim.value = false
        }
    }

}