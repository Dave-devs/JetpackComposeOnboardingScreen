package com.example.jetpackcomposeonboardingscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.util.Routes
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.screens.AnimatedSplashScreen
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.screens.HomeScreen
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.screens.WelcomeScreen
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.viewmodel.SplashViewModel
import com.example.jetpackcomposeonboardingscreen.ui.theme.JetpackComposeOnboardingScreenTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeOnboardingScreenTheme {
                val route by splashViewModel.startDestination
                val navController = rememberNavController()
               NavHost(
                    navController = navController,
                    startDestination = route
                ) {
                    composable(route = Routes.SPLASH_SCREEN) {
                        AnimatedSplashScreen(navController)
                    }
                    composable(route = Routes.WELCOME_SCREEN) {
                        WelcomeScreen(navController)
                    }
                    composable(route = Routes.HOME_SCREEN) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}