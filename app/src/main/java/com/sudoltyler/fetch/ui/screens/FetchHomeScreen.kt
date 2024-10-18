package com.sudoltyler.fetch.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
    modifier: Modifier = Modifier,
    fetchUiState: FetchUiState,
    onFetchButtonClicked: () -> Unit
) {
//    Column(
////        modifier = Modifier
////            .fillMaxSize()
////            .statusBarsPadding()
////            .verticalScroll(rememberScrollState())
////            .safeDrawingPadding()
////            .padding(16.dp),
////        verticalArrangement = Arrangement.Center,
////        horizontalAlignment = Alignment.CenterHorizontally
////    ) {
////        Text(
////            text = stringResource(R.string.main_title),
////            style = typography.titleLarge
////        )
////        Spacer(modifier = Modifier.height(16.dp))
////        Button(
////            onClick = onFetchButtonClicked,
////            modifier = modifier
////        ) {
////            Text(stringResource(R.string.fetch_button))
////        }
////    }

    when (fetchUiState) {
        is FetchUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is FetchUiState.Success -> ResultScreen(
            fetchUiState.data, modifier = modifier.fillMaxWidth()
        )
        is FetchUiState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}
