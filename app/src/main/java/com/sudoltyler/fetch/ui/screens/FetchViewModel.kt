package com.sudoltyler.fetch.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.sudoltyler.fetch.FetchApplication
import com.sudoltyler.fetch.data.FetchRepository
import com.sudoltyler.fetch.network.FetchData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface FetchUiState {
    data class Success(val data: Map<Long, List<FetchData>>) : FetchUiState
    data object Error : FetchUiState
    data object Loading : FetchUiState
}

// viewmodel interfaces with the ui state to update the ui elements, separating state from display
class FetchViewModel(private val fetchRepository: FetchRepository) : ViewModel() {
    var fetchUiState: FetchUiState by mutableStateOf(FetchUiState.Loading)
        private set

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            fetchUiState = FetchUiState.Loading
            fetchUiState = try {
                val listResult = fetchRepository.getList()
                val filteredList = listResult.filter {it.name != "" && it.name != null}
                val sortedList =
                    filteredList.sortedWith(compareBy<FetchData> {it.listId}
                        .thenBy { it.name?.drop(5)?.toInt() })
                val resultByListId = sortedList.groupBy { it.listId }
                FetchUiState.Success(resultByListId)
            } catch (e: IOException) {
                FetchUiState.Error
            } catch (e: HttpException) {
                FetchUiState.Error
            }
        }
    }

    companion object {
        val Factory: Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FetchApplication)
                val fetchRepository = application.container.fetchRepository
                FetchViewModel(fetchRepository = fetchRepository)
            }
        }
    }
}