package com.ashr.cleanMvvmSocket.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashr.cleanMvvmSocket.R
import com.ashr.cleanMvvmSocket.presentation.ui.theme.*
import com.ashr.cleanMvvmSocket.presentation.ui.widget.AppDivider
import com.ashr.cleanMvvmSocket.presentation.ui.widget.LinearLoadingView
import java.text.DecimalFormat

@Composable
fun DetailScreen(productId: String?) {
    val viewModel: TickerViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.getCryptos(productId)
    }

    Column {
        if (uiState.isLoading) {
            LinearLoadingView()
        }
        if (!uiState.isOnline) {
            Text(
                text = stringResource(id = if (uiState.isLoading) R.string.offline else R.string.offline_still),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xffc1f8fe))
                    .padding(vertical = 10.dp),
                style = MaterialTheme.typography.h4.copy(color = MaterialTheme.colors.primary),
                textAlign = TextAlign.Center
            )
        }
        if (uiState.data.isNotEmpty()) {
            uiState.data[0].let { ticker ->
                val asc = (ticker.openPrice < ticker.price)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 280.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = mutableListOf(
                                    MaterialTheme.colors.primary,
                                    if (asc) GradientFirstGreen else GradientFirstRed,
                                ),
                            ),
                        )
                ) {
                    Image(
                        painterResource(getProductResource(ticker.productCode)),
                        contentDescription = null,
                        modifier = Modifier
                            .requiredSize(60.dp)
                            .clip(shape = RoundedCornerShape(20.dp))

                    )
                    Text(
                        "$ ${ticker.price}",
                        modifier = Modifier.padding(20.dp),
                        style = MaterialTheme.typography.h1
                    )
                    val gain =
                        ((ticker.price - ticker.openPrice) / (ticker.openPrice)) * 100
                    val gainSymbol = if (gain > 0) "▲ +" else "▼ "
                    Text(
                        "$gainSymbol${
                            DecimalFormat("#.###").format(gain)
                        }% (24h)",
                        modifier = Modifier
                            .padding(20.dp)
                            .background(
                                color = if (gain > 0) GreenBack else REDBack,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        style = MaterialTheme.typography.h4.copy(color = if (gain > 0) Green else RED)
                    )
                }

                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.open_price),
                            style = MaterialTheme.typography.subtitle1
                        )
                        Text(text = "$${ticker.openPrice}", style = MaterialTheme.typography.h3)
                    }
                    AppDivider()
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.volume_24h),
                            style = MaterialTheme.typography.subtitle1
                        )
                        Text(text = "$${ticker.volume24}", style = MaterialTheme.typography.h3)
                    }
                    AppDivider()
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.volume_month),
                            style = MaterialTheme.typography.subtitle1
                        )
                        Text(text = "$${ticker.volumeMonth}", style = MaterialTheme.typography.h3)
                    }
                    AppDivider()
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.low_24h),
                            style = MaterialTheme.typography.subtitle1
                        )
                        Text(text = "$${ticker.low24}", style = MaterialTheme.typography.h3)
                    }
                    AppDivider()
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.high_24h),
                            style = MaterialTheme.typography.subtitle1
                        )
                        Text(text = "$${ticker.high24}", style = MaterialTheme.typography.h3)
                    }
                }

            }
        }
    }


}