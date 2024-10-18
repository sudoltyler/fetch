package com.sudoltyler.fetch.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sudoltyler.fetch.R
import com.sudoltyler.fetch.network.FetchData


@Composable
fun FetchDetailsScreen(
    fetchUiState: FetchUiState,
    modifier: Modifier = Modifier
) {
    when (fetchUiState) {
        is FetchUiState.Loading -> LoadingScreen()
        is FetchUiState.Success -> ResultScreen(
            data = fetchUiState.data, modifier = modifier.fillMaxWidth()
        )
        is FetchUiState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}

@Composable
fun ResultScreen(data: Map<Long, List<FetchData>>, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.padding(horizontal = 12.dp, vertical = 48.dp)
    ) {
        LazyColumn {
            item {
                Text("Data from Fetch server\n")
            }
            items(data.toList()) { (k, v) ->
                Text("Items with ListId $k:\n")
                v.forEach { Text("${it.name}, ID: ${it.id}") }
                Text("\n")
            }
        }
    }
}

@Composable
fun LoadingScreen() {
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
            text = stringResource(R.string.loading),
            style = typography.titleLarge
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.failed_to_load), modifier = Modifier.padding(16.dp))
    }
}