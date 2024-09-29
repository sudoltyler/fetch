package com.sudoltyler.fetch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sudoltyler.fetch.ui.FetchHomeScreen
import com.sudoltyler.fetch.ui.FetchViewModel

@Composable
fun FetchApp(
    modifier: Modifier = Modifier
) {
    val viewModel: FetchViewModel = viewModel()
    val fetchUiState = viewModel.uiState.collectAsState().value

    FetchHomeScreen(
        fetchUiState = fetchUiState,
        modifier = modifier
    )
}