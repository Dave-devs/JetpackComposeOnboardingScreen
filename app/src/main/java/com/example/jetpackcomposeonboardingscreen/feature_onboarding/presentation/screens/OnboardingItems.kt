package com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.screens

import androidx.annotation.DrawableRes
import com.example.jetpackcomposeonboardingscreen.R

sealed class OnboardingItems(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
    ) {
    object First: OnboardingItems(
        image = R.drawable.oboard_pic1,
        title = "Management",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
    object Second: OnboardingItems(
        image = R.drawable.onborad_pic2,
        title = "Coordination",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
    object Third: OnboardingItems(
        image = R.drawable.onborad_pic3,
        title = "Result",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
    object Fourth: OnboardingItems(
        image = R.drawable.onborad_pic4,
        title = "Success",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
    object Fifth: OnboardingItems(
        image = R.drawable.oboard_pic1,
        title = "Growth",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}
