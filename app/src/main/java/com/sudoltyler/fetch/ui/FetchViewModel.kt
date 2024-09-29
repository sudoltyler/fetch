package com.sudoltyler.fetch.ui

import androidx.lifecycle.ViewModel
import com.sudoltyler.fetch.data.FetchUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// viewmodel interfaces with the ui state to update the ui elements, separating state from display
class FetchViewModel : ViewModel() {
    // expose screen ui state
    private val _uiState = MutableStateFlow(FetchUiState())
    val uiState: StateFlow<FetchUiState> = _uiState.asStateFlow()

    init {
        initUiState()
    }

    private fun initUiState() {
        _uiState.value =
            FetchUiState(
                isShowingHomepage = true
            )
    }
}