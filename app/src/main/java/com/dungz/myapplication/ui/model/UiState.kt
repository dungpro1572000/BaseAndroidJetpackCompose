package com.dungz.myapplication.ui.model

/**
 * Base UI state sealed class for representing different states of the UI.
 * TODO: Add more specific states as needed (Loading, Success, Error, Empty, etc.)
 */
sealed class UiState<out T> {
    data object Idle : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String, val throwable: Throwable? = null) : UiState<Nothing>()
    data object Empty : UiState<Nothing>()
}

/**
 * Extension function to get data from UI state if it's Success.
 */
fun <T> UiState<T>.getDataOrNull(): T? {
    return when (this) {
        is UiState.Success -> data
        else -> null
    }
}

/**
 * Extension function to check if UI state is loading.
 */
fun <T> UiState<T>.isLoading(): Boolean = this is UiState.Loading

/**
 * Extension function to check if UI state is error.
 */
fun <T> UiState<T>.isError(): Boolean = this is UiState.Error

/**
 * Extension function to check if UI state is success.
 */
fun <T> UiState<T>.isSuccess(): Boolean = this is UiState.Success
