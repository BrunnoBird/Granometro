package com.example.granometro.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.granometro.R

@Composable
fun SplashScreen(
    onAnimationFinished: () -> Unit
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = 1,
        speed = 1f,
        restartOnPlay = false
    )
    val isFinished = remember { mutableStateOf(false) }

    if (progress == 1f && !isFinished.value) {
        isFinished.value = true
        onAnimationFinished()
    }

    LottieAnimation(
        modifier = Modifier.fillMaxSize(),
        composition = composition,
        progress = { progress },
    )
}