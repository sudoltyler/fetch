package com.sudoltyler.fetch.ui

import androidx.annotation.StringRes
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sudoltyler.fetch.R
import com.sudoltyler.fetch.ui.screens.FetchDetailsScreen
import com.sudoltyler.fetch.ui.screens.FetchHomeScreen
import com.sudoltyler.fetch.ui.screens.FetchViewModel

enum class FetchScreen(@StringRes val title: Int) {
    Start(title = R.string.start_screen),
    Details(title = R.string.details_screen)
}

@Composable
fun FetchApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = FetchScreen.valueOf(
        backStackEntry?.destination?.route ?: FetchScreen.Start.name
    )

    Surface {
        val fetchViewModel: FetchViewModel =
            viewModel(factory = FetchViewModel.Factory)

        val fetchUiState = fetchViewModel.fetchUiState

        NavHost(
            navController = navController,
            startDestination = FetchScreen.Start.name,
            modifier = modifier
        ) {
            composable(route = FetchScreen.Start.name) {
                FetchHomeScreen(
                    fetchUiState = fetchUiState,
                    onFetchButtonClicked = {
                        navController.navigate(FetchScreen.Details.name)
                    },
                    modifier = modifier
                )
            }
            composable(route = FetchScreen.Details.name) {
                FetchDetailsScreen(
                    fetchUiState = fetchUiState,
                    modifier = modifier
                )
            }
        }
    }
}