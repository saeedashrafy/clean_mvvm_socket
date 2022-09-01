package com.ashr.cleanMvvmSocket.presentation.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val Transparent = Color(0x00000000)
val Blue = Color(0xff5147e8)
val NavyBlue = Color(0xff181822)
val RedDark = Color(0xFF982626)

val Green = Color(0xFF42997a)
val GreenBack = Color(0xFF437462)
val RED = Color(0xFFaa4552)
val REDBack = Color(0xFF77434B)

val CardDark = NavyBlue
val CardLight = White

val BackgroundLight = Color(0xFFF5F2F5)
val BackgroundDark = Black //Color(0xFF24292E)

val DividerLight = Color(0XFFF2F4F5)
val DividerDark = Color(0xFF3F3E3E)

val Gray = Color(0xfff2f3f6)
val LightGray = Color(0xFF4B535A)

val GradientFirstGreen = Color(0xff0a1a19)
val GradientFirstRed = Color(0xff180809)
val GradientThird = Color(0xFF101010)


val RedBackground = Color(0xFFFDEAED)

val navigationBackIconDark = White
val navigationBackIconLight = Black

val Colors.navigationBackIconColor: Color
    @Composable get() = if (isLight) navigationBackIconLight else navigationBackIconDark

val Colors.dividerColor: Color
    @Composable get() = if (isLight) DividerLight else DividerDark

val Colors.backgroundColor: Color
    @Composable get() = if (isLight) BackgroundLight else BackgroundDark

val Colors.cardBackgroundColor: Color
    @Composable get() = if (isLight) CardLight else CardDark