package com.example.jetpackcomposeonboardingscreen.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetpackcomposeonboardingscreen.core.util.Routes
import com.example.jetpackcomposeonboardingscreen.presentation.viewmodel.WelcomeViewModel
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
         OnboardingScreens(onboardingItems = pages[position])
      }
      HorizontalPagerIndicator(
         pagerState = pagerState,
         modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterHorizontally)
      )
      FinishButton(
         pagerState = pagerState,
         modifier = Modifier
            .weight(1f)
      ) {
         welcomeViewModel.saveOnBoardingState(true)
         navController.popBackStack()
         navController.navigate(Routes.HOME_SCREEN)
      }
   }
}

@Composable
fun OnboardingScreens(
   onboardingItems: OnboardingItems
) {
   Row(modifier = Modifier
      .fillMaxWidth()
      .padding(end = 16.dp),
      verticalAlignment = Alignment.Top,
      horizontalArrangement = Arrangement.End
   ) {
      Text(
         text = "Skip",
         fontSize = 20.sp,
         textAlign = TextAlign.End
      )
   }
   Column(
      modifier = Modifier
         .fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Top
   ) {
      Image(
         painter = painterResource(id = onboardingItems.image),
         contentDescription = "Item image",
         modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.7f)
            .size(200.dp)
      )
      Text(
         text = onboardingItems.title,
         fontSize = 36.sp,
         fontWeight = FontWeight.Bold,
         textAlign = TextAlign.Center,
         modifier = Modifier.fillMaxWidth()
      )
      Text(
         text = onboardingItems.description,
         fontSize = 20.sp,
         fontWeight = FontWeight.Medium,
         textAlign = TextAlign.Center,
         modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .padding(top = 20.dp)
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