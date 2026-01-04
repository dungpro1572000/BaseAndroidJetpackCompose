package com.dungz.myapplication.ui.screen.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dungz.myapplication.ui.model.UiState

/**
 * Example screen demonstrating how to consume ViewModel.
 * TODO: Replace with your actual screen
 */
@Composable
fun ExampleScreen(
    viewModel: ExampleViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { viewModel.refresh() },
            enabled = !uiState.isRefreshing
        ) {
            Text(if (uiState.isRefreshing) "Refreshing..." else "Refresh")
        }

        when (val examplesState = uiState.examples) {
            is UiState.Idle -> {
                // TODO: Show initial state UI
            }

            is UiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Success -> {
                LazyColumn {
                    items(examplesState.data) { example ->
                        ExampleItem(
                            example = example,
                            onClick = { viewModel.selectExample(example) }
                        )
                    }
                }
            }

            is UiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Error: ${examplesState.message}")
                        Button(onClick = { viewModel.loadExamples() }) {
                            Text("Retry")
                        }
                    }
                }
            }

            is UiState.Empty -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No data available")
                }
            }
        }
    }
}

@Composable
private fun ExampleItem(
    example: com.dungz.domain.model.ExampleModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(8.dp)
    ) {
        Text(text = example.title)
        Text(text = example.description)
    }
}
