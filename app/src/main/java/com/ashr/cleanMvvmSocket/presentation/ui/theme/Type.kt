package com.ashr.cleanMvvmSocket.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with


val Typography = Typography(
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        textDirection = TextDirection.Content,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontWeight = FontWeight.Black,
        textDirection = TextDirection.Content,
        fontSize = 38.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        textDirection = TextDirection.Content,
        fontSize = 19.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        textDirection = TextDirection.Content,
        fontSize = 15.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        textDirection = TextDirection.Content,
        fontSize = 15.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Medium,
        textDirection = TextDirection.Content,
        fontSize = 14.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Thin,
        textDirection = TextDirection.Content,
        fontSize = 12.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Bold,
        textDirection = TextDirection.Content,
        color = Color.Gray,
        fontSize = 15.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Bold,
        textDirection = TextDirection.Content,
        color = Color.Gray,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        textDirection = TextDirection.Content,
        textAlign = TextAlign.Center,
        fontSize = 14.sp
    ),
)