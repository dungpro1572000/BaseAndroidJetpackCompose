package com.dungz.domain.repository

import com.dungz.domain.model.ExampleModel
import kotlinx.coroutines.flow.Flow

/**
 * Example repository interface demonstrating how to extend BaseRepository.
 * TODO: Replace with your actual repository interfaces
 */
interface ExampleRepository : BaseRepository<ExampleModel> {
    /**
     * Get all examples.
     * TODO: Implement offline-first strategy (return Flow from Room, sync with network)
     */
    fun getAll(): Flow<List<ExampleModel>>

    /**
     * Get example by ID.
     * TODO: Implement offline-first strategy
     */
    fun getById(id: Long): Flow<ExampleModel?>

    /**
     * Refresh data from network.
     * TODO: Implement error handling, offline strategy
     */
    suspend fun refresh()

    /**
     * Get paginated data.
     * TODO: Implement pagination with Room Paging
     */
    fun getPaged(page: Int = 1, limit: Int = 20): Flow<List<ExampleModel>>
}
