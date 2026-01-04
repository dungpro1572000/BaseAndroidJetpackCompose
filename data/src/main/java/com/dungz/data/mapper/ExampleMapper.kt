package com.dungz.data.mapper

import com.dungz.data.local.entity.ExampleEntity
import com.dungz.data.remote.dto.ExampleDto

/**
 * Example mapper demonstrating DTO to Entity conversion.
 * TODO: Replace with your actual mappers
 */
class ExampleMapper : BaseMapper<ExampleDto, ExampleEntity> {
    override fun toEntity(dto: ExampleDto): ExampleEntity {
        val currentTime = System.currentTimeMillis()
        return ExampleEntity(
            id = dto.id,
            title = dto.title ?: "",
            description = dto.description ?: "",
            createdAt = currentTime,
            updatedAt = currentTime
        )
    }

    override fun toDto(entity: ExampleEntity): ExampleDto {
        return ExampleDto(
            id = entity.id,
            title = entity.title,
            description = entity.description
        )
    }

    fun toEntityList(dtos: List<ExampleDto>): List<ExampleEntity> {
        return dtos.map { toEntity(it) }
    }
}
