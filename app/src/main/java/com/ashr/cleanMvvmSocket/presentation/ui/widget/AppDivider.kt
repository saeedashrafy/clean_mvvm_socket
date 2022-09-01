package com.ashr.cleanMvvmSocket.presentation.ui.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ashr.cleanMvvmSocket.presentation.ui.theme.dividerColor


@Composable
fun AppDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        thickness = 0.5.dp,
        color = MaterialTheme.colors.dividerColor
    )
}