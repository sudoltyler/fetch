package com.sudoltyler.fetch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sudoltyler.fetch.R
import com.sudoltyler.fetch.ui.theme.FetchTheme

// Composable for the home screen of the app
@Composable
fun FetchHomeScreen(
    fetchUiState: FetchUiState,
    modifier: Modifier = Modifier
) {
    if (fetchUiState.isShowingHomepage) {
        FetchAppContent(
            modifier = modifier
        )
    } else {
        // details screen

    }
}

@Composable
fun FetchAppContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.main_title),
            style = typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FetchHomePreview() {
    FetchTheme {
        FetchAppContent()
    }
}