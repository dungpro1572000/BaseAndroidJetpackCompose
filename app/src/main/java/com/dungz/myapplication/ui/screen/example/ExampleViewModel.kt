package com.dungz.myapplication.ui.screen.example

import androidx.lifecycle.viewModelScope
import com.dungz.domain.repository.ExampleRepository
import com.dungz.myapplication.ui.base.BaseViewModel
import com.dungz.myapplication.ui.model.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Example ViewModel demonstrating how to extend BaseViewModel.
 * TODO: Replace with your actual ViewModel
 */
@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val repository: ExampleRepository
) : BaseViewModel<ExampleUiState>() {

    init {
        loadExamples()
    }

    override fun createInitialState(): ExampleUiState {
        return ExampleUiState()
    }

    /**
     * Load examples from repository.
     */
    fun loadExamples() {
        updateState { copy(examples = UiState.Loading) }

        viewModelScope.launch {
            repository.getAll()
                .map { examples ->
                    if (examples.isEmpty()) {
                        UiState.Empty
                    } else {
                        UiState.Success(examples)
                    }
                }
                .catch { throwable ->
                    UiState.Error(
                        message = throwable.message ?: "Unknown error",
                        throwable = throwable
                    )
                }
                .collect { state ->
                    updateState { copy(examples = state) }
                }
        }
    }

    /**
     * Refresh examples from network.
     */
    fun refresh() {
        updateState { copy(isRefreshing = true) }

        launchWithErrorHandling(
            errorMessage = "Failed to refresh examples"
        ) {
            repository.refresh()
            updateState { copy(isRefreshing = false) }
        }
    }

    /**
     * Select an example.
     */
    fun selectExample(example: com.dungz.domain.model.ExampleModel) {
        updateState { copy(selectedExample = example) }
    }

    /**
     * Clear selected example.
     */
    fun clearSelection() {
        updateState { copy(selectedExample = null) }
    }
}
