package com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Box(modifier = modifier
        .fillMaxSize(),
        contentAlignment = (Alignment.Center)
    ) {
        Home()
    }
}

@Composable
fun Home() {
    Text(
        text = "Home",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}