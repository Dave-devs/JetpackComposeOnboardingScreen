package com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.util.Routes
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.presentation.viewmodel.WelcomeViewModel
import com.google.accompanist.pager.*

@ExperimentalAnimationApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
   navController: NavController,
   welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
   val pages = listOf(
      OnboardingItems.First,
      OnboardingItems.Second,
      OnboardingItems.Third,
      OnboardingItems.Fourth,
      OnboardingItems.Fifth,
   )
   val pagerState = rememberPagerState()

   Column(modifier = Modifier.fillMaxSize()) {
      HorizontalPager(
         modifier = Modifier.weight(10f),
         count = 5,
         state = pagerState,
         verticalAlignment = Alignment.Top
      ) { position ->
         OnBoardingScreens(onBoardingItems = pages[position])
      }
      HorizontalPagerIndicator(
         modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .weight(1f),
         pagerState = pagerState
      )
      FinishButton(
         modifier = Modifier.weight(1f),
         pagerState = pagerState
      ) {
         welcomeViewModel.saveOnBoardingState(completed = true)
         navController.popBackStack()
         navController.navigate(Routes.HOME_SCREEN)
      }
   }
}

@Composable
fun OnBoardingScreens(
   onBoardingItems: OnboardingItems
) {
   Column(
      modifier = Modifier
         .fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Top
   ) {
      Image(
         modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.7f),
         painter = painterResource(id = onBoardingItems.image),
         contentDescription = "Item image"
      )
      Text(
         modifier = Modifier.fillMaxWidth(),
         text = onBoardingItems.title,
         fontSize = 34.sp,
         fontWeight = FontWeight.Bold,
         textAlign = TextAlign.Center
      )
      Text(
         modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .padding(top = 20.dp),
         text = onBoardingItems.description,
         fontSize = 16.sp,
         fontWeight = FontWeight.Medium,
         textAlign = TextAlign.Center
      )
   }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(
   modifier: Modifier = Modifier,
   pagerState: PagerState,
   onClick: () -> Unit
) {
   Row(
      modifier = modifier
         .padding(horizontal = 40.dp),
      verticalAlignment = Alignment.Top,
      horizontalArrangement = Arrangement.Center
   ) {
      AnimatedVisibility(
         modifier = Modifier.fillMaxWidth(),
         visible = pagerState.currentPage == 4
      ) {
        Button(
           onClick = onClick,
           colors = ButtonDefaults.buttonColors(
              contentColor = Color.White
           )
        ) {
           Text(text = "Finish")
        }
      }
   }
}


@Composable
@Preview(showBackground = true)
fun OnBoardingScreensPreview() {
   OnBoardingScreens(onBoardingItems = OnboardingItems.First)
}