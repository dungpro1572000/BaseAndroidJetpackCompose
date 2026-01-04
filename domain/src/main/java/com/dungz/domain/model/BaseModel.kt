package com.dungz.domain.model

/**
 * Base model interface for domain models.
 * All domain models should implement this interface.
 * TODO: Add common fields that all models share
 */
interface BaseModel {
    val id: Long?
    val createdAt: Long
    val updatedAt: Long
}
