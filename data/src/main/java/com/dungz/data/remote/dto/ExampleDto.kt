package com.dungz.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Example DTO demonstrating network response model.
 * TODO: Replace with your actual DTOs
 */
@JsonClass(generateAdapter = true)
data class ExampleDto(
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "description")
    val description: String? = null
    // TODO: Add your DTO fields here
) : BaseDto
