package com.dungz.data.mapper

/**
 * Base mapper interface for converting between DTO and Entity.
 * TODO: Implement mappers for your models
 */
interface BaseMapper<DTO, Entity> {
    fun toEntity(dto: DTO): Entity
    fun toDto(entity: Entity): DTO
}
