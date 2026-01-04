package com.dungz.data.repository

import com.dungz.data.local.dao.ExampleDao
import com.dungz.data.mapper.ExampleMapper
import com.dungz.data.remote.api.ApiService
import com.dungz.domain.model.ExampleModel
import com.dungz.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Example repository implementation connecting Room and Retrofit.
 * TODO: Replace with your actual repository implementation
 * TODO: Implement offline-first strategy
 * TODO: Implement error handling
 * TODO: Implement caching strategy
 * TODO: Implement pagination
 */
class ExampleRepositoryImpl @Inject constructor(
    private val dao: ExampleDao,
    private val apiService: ApiService,
    private val mapper: ExampleMapper
) : ExampleRepository {

    override fun getAll(): Flow<List<ExampleModel>> {
        // TODO: Implement offline-first: return Flow from Room, sync in background
        return dao.getAll().map { entities ->
            entities.map { entity ->
                ExampleModel(
                    id = entity.id,
                    createdAt = entity.createdAt,
                    updatedAt = entity.updatedAt,
                    title = entity.title,
                    description = entity.description
                )
            }
        }
    }

    override fun getById(id: Long): Flow<ExampleModel?> {
        // TODO: Implement offline-first strategy
        return dao.getById(id).map { entity ->
            entity?.let {
                ExampleModel(
                    id = it.id,
                    createdAt = it.createdAt,
                    updatedAt = it.updatedAt,
                    title = it.title,
                    description = it.description
                )
            }
        }
    }

    override suspend fun refresh() {
        // TODO: Implement error handling
        // TODO: Handle offline scenarios
        try {
            val response = apiService.getExamples()
            if (response.isSuccessful) {
                val dtos = response.body() ?: emptyList()
                val entities = mapper.toEntityList(dtos)
                // TODO: Handle update strategy (insert vs replace)
                dao.insertAll(entities)
            }
        } catch (e: Exception) {
            // TODO: Handle error (log, show error, etc.)
        }
    }

    override fun getPaged(page: Int, limit: Int): Flow<List<ExampleModel>> {
        // TODO: Implement Room Paging 3.0
        // TODO: Use RemoteMediator for offline-first pagination
        return getAll()
    }
}
