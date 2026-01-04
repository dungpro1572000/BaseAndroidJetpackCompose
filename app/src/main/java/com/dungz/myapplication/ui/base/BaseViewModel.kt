package com.dungz.myapplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Base ViewModel for all ViewModels in the app.
 * Provides common functionality like error handling and state management.
 * TODO: Add analytics/logging integration
 * TODO: Add error reporting (Crashlytics, etc.)
 */
abstract class BaseViewModel<UIState> : ViewModel() {

    private val _uiState = MutableStateFlow(createInitialState())
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    protected val currentState: UIState
        get() = _uiState.value

    /**
     * Create initial UI state.
     */
    protected abstract fun createInitialState(): UIState

    /**
     * Update UI state.
     */
    protected fun updateState(update: UIState.() -> UIState) {
        _uiState.value = _uiState.value.update()
    }

    /**
     * Set UI state directly.
     */
    protected fun setState(newState: UIState) {
        _uiState.value = newState
    }

    /**
     * Execute a coroutine with error handling.
     */
    protected fun launchWithErrorHandling(
        errorMessage: String = "An error occurred",
        onError: ((Throwable) -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit
    ) {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            // TODO: Log error
            // TODO: Report to error tracking service
            onError?.invoke(throwable)
        }

        viewModelScope.launch(exceptionHandler) {
            block()
        }
    }
}
