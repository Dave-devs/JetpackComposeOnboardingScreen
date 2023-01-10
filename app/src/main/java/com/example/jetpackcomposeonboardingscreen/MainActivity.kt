package com.example.jetpackcomposeonboardingscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeonboardingscreen.core.util.Routes
import com.example.jetpackcomposeonboardingscreen.presentation.screens.AnimatedSplashScreen
import com.example.jetpackcomposeonboardingscreen.presentation.screens.HomeScreen
import com.example.jetpackcomposeonboardingscreen.presentation.screens.WelcomeScreen
import com.example.jetpackcomposeonboardingscreen.presentation.viewmodel.SplashViewModel
import com.example.jetpackcomposeonboardingscreen.ui.theme.JetpackComposeOnboardingScreenTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var splashViewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{!splashViewModel.isLoading.value}
        setContent {
            JetpackComposeOnboardingScreenTheme {
                // A surface container using the 'background' color from the theme
                val screen by splashViewModel.startDestination
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.SPLASH_SCREEN
                ) {
                    composable(route = Routes.SPLASH_SCREEN) {
                        AnimatedSplashScreen()
                    }
                    composable(route = Routes.WELCOME_SCREEN) {
                        WelcomeScreen(navController = navController)
                    }
                    composable(route = Routes.HOME_SCREEN) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}