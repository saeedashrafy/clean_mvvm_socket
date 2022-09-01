package com.ashr.cleanMvvmSocket.presentation.ui.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CircularLoadingView() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally),
        color = MaterialTheme.colors.primaryVariant
    )
}

@Composable
fun LinearLoadingView() {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.primaryVariant
    )
}