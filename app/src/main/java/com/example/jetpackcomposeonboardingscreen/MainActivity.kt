package com.example.jetpackcomposeonboardingscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeonboardingscreen.onBoardingApp.Routes
import com.example.jetpackcomposeonboardingscreen.ui.theme.JetpackComposeOnboardingScreenTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeOnboardingScreenTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.ONBOARDING_SCREEN
                ) {
                    composable(route = Routes.ONBOARDING_SCREEN) {

                    }
                    composable(route = Routes.HOME_SCREEN) {

                    }
                }
            }
        }
    }
}