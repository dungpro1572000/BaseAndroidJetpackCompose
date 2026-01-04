package com.dungz.myapplication.ui.screen.example

import com.dungz.domain.model.ExampleModel
import com.dungz.myapplication.ui.model.UiState

/**
 * UI state for Example screen.
 * TODO: Replace with your actual UI state
 */
data class ExampleUiState(
    val examples: UiState<List<ExampleModel>> = UiState.Idle,
    val selectedExample: ExampleModel? = null,
    val isRefreshing: Boolean = false
    // TODO: Add more UI state fields as needed
)
