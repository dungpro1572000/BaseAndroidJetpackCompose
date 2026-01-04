package com.dungz.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Example entity demonstrating how to implement BaseEntity.
 * TODO: Replace with your actual entity
 */
@Entity(tableName = "example")
data class ExampleEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Long? = null,
    override val createdAt: Long = System.currentTimeMillis(),
    override val updatedAt: Long = System.currentTimeMillis(),
    // TODO: Add your entity fields here
    val title: String = "",
    val description: String = ""
) : BaseEntity