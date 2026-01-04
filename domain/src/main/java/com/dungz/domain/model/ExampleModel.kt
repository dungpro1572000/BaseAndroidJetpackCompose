package com.dungz.domain.model

/**
 * Example domain model.
 * TODO: Replace with your actual domain models
 */
data class ExampleModel(
    override val id: Long? = null,
    override val createdAt: Long = 0L,
    override val updatedAt: Long = 0L,
    // TODO: Add your model fields here
    val title: String = "",
    val description: String = ""
) : BaseModel
