package com.example.jetpackcomposeonboardingscreen.presentation.screens

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
        description = "It is a long established fact that a reader will be distracted by " +
                "the readable content of a page when looking at its layout."
    )
    object Second: OnboardingItems(
        image = R.drawable.onborad_pic2,
        title = "Coordination",
        description = "It is a long established fact that a reader will be distracted by " +
                "the readable content of a page when looking at its layout."
    )
    object Third: OnboardingItems(
        image = R.drawable.onborad_pic3,
        title = "Result",
        description = "It is a long established fact that a reader will be distracted " +
                "by the readable content of a page when looking at its layout."
    )
    object Fourth: OnboardingItems(
        image = R.drawable.onborad_pic4,
        title = "Success",
        description = "It is a long established fact that a reader will be distracted by" +
                " the readable content of a page when looking at its layout."
    )
    object Fifth: OnboardingItems(
        image = R.drawable.oboard_pic1,
        title = "Growth",
        description = "It is a long established fact that a reader will be distracted by " +
                "the readable content of a page when looking at its layout."
    )
}
