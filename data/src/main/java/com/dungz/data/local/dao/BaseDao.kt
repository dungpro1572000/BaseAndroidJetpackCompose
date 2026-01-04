package com.dungz.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * Base DAO interface providing common database operations pattern.
 * Note: Room DAOs cannot use generics, so each DAO must implement these methods
 * with concrete types. This interface serves as a documentation/pattern reference.
 * TODO: Implement these methods in each concrete DAO
 */
interface BaseDao<T> {
    // Pattern methods - implement in concrete DAOs with @Insert, @Update, @Delete annotations
    suspend fun insert(item: T): Long
    suspend fun insertAll(items: List<T>): List<Long>
    suspend fun update(item: T)
    suspend fun updateAll(items: List<T>)
    suspend fun delete(item: T)
    suspend fun deleteAll(items: List<T>)
}
