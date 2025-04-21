package com.example.granometro.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Paid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.granometro.core_ui.colors.GeneralColor
import java.math.BigDecimal
import java.math.RoundingMode

@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel: HomeViewModel = viewModel()
    val uiState = viewModel.uiState

    LaunchedEffect(Unit) {
        viewModel.handleEvent(HomeEvent.LoadData)
    }

    Scaffold(
        bottomBar = {}
    ) { innerPaddings ->
        HomeScreenContent(
            modifier = Modifier
                .padding(innerPaddings)
                .fillMaxSize(),
            uiState
        )
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    uiState: HomeUiState
) {
    Column(modifier) {
        if (uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Icon(
                imageVector = Icons.Rounded.Paid,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(vertical = 26.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(100.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        "Meta do Mês: ",
                        modifier = Modifier,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        "R$ ${uiState.maxMonthValueExpense}",
                        modifier = Modifier,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Saldo do Mês: ",
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            "R$ ${uiState.monthRemaining}",
                            modifier = Modifier,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    //monthRemaining / 1000 -> valor da progress
                    val currentMonthProgress = calculateProgress(
                        current = uiState.monthRemaining,
                        max = uiState.maxMonthExpense
                    )
                    LinearProgressIndicator(
                        progress = { currentProgress },
                        trackColor = MaterialTheme.colorScheme.primary,
                        color = when {
                            currentProgress <= 0.50f -> GeneralColor.Success
                            currentProgress <= 0.75f -> GeneralColor.Warning
                            else -> MaterialTheme.colorScheme.error
                        }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Saldo do Dia: ",
                            modifier = Modifier,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            "R$ ${uiState.dayRemaining}",
                            modifier = Modifier,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    //dayRemaining / idealDayLimit -> valor da progress
                    val dayProgress = calculateProgress(
                        current = uiState.dayRemaining,
                        max = uiState.idealDayLimit
                    )
                    LinearProgressIndicator(
                        progress = { dayProgress },
                        trackColor = MaterialTheme.colorScheme.primary,
                        color = when {
                            dayProgress <= 0.50f -> GeneralColor.Success
                            dayProgress <= 0.75f -> GeneralColor.Warning
                            else -> MaterialTheme.colorScheme.error
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(
        uiState = HomeUiState(
            isLoading = false,
            maxMonthExpense = BigDecimal("1000.00"),
            monthRemaining = BigDecimal("200.00"),
            dayRemaining = BigDecimal("50.00")
        )
    )
}
