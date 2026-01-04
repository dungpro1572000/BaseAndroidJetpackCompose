package com.dungz.data.local.entity

/**
 * Base entity interface for Room database entities.
 * All entities should implement this interface.
 * TODO: Add common fields that all entities share
 */
interface BaseEntity {
    val id: Long?
    val createdAt: Long
    val updatedAt: Long
}
