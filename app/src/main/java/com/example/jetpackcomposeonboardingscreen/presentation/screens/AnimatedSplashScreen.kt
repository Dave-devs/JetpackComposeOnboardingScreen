package com.example.jetpackcomposeonboardingscreen.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposeonboardingscreen.R
import com.example.jetpackcomposeonboardingscreen.core.util.Constants.DELAY
import com.example.jetpackcomposeonboardingscreen.core.util.Constants.DURATION_MILLIS
import com.example.jetpackcomposeonboardingscreen.core.util.Routes
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen() {
    var startAnim by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnim) 1f else 0f,
        animationSpec = tween(
            durationMillis = DURATION_MILLIS
        )
    )

    LaunchedEffect(key1 = true) {
        startAnim = true
        delay(DELAY)
        //navController.navigate(Routes.ONBOARDING_SCREEN)
    }
    SplashScreen(alpha = alphaAnim.value)
}


@Composable
fun SplashScreen(
    alpha: Float,
    modifier: Modifier = Modifier
) {
    val rainbowColorBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD),
            )
        )
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        val borderWidth = 4.dp
        Image(
            painter = painterResource(id = R.drawable.social_synergy_logo),
            contentDescription = "logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .border(
                    BorderStroke(borderWidth, rainbowColorBrush),
                    shape = RoundedCornerShape(15.dp)
                )
                .alpha(alpha = alpha)
                .padding(borderWidth)
                .size(120.dp)
                .clip(RoundedCornerShape(16.dp))
        )
    }
}


@Composable
@Preview
fun AnimatedSplashScreenPreview() {
    SplashScreen(alpha = 1f)
}