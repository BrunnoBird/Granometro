package com.example.granometro.core_ui

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.example.granometro.core_ui.colors.DarkBackground
import com.example.granometro.core_ui.colors.DarkError
import com.example.granometro.core_ui.colors.DarkOnBackground
import com.example.granometro.core_ui.colors.DarkOnPrimary
import com.example.granometro.core_ui.colors.DarkPrimary
import com.example.granometro.core_ui.colors.LightBackground
import com.example.granometro.core_ui.colors.LightError
import com.example.granometro.core_ui.colors.LightOnBackground
import com.example.granometro.core_ui.colors.LightOnPrimary
import com.example.granometro.core_ui.colors.LightPrimary

internal  val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    background = LightBackground,
    onBackground = LightOnBackground,
    error = LightError
    // warning/positive não são nativos, mas podem ser usados como extensão
)

internal val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    error = DarkError
)