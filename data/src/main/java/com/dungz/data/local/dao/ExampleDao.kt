package com.dungz.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dungz.data.local.entity.ExampleEntity
import kotlinx.coroutines.flow.Flow

/**
 * Example DAO demonstrating Room DAO pattern.
 * Follows BaseDao pattern but implements methods with Room annotations.
 * TODO: Replace with your actual DAO
 */
@Dao
interface ExampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ExampleEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ExampleEntity>): List<Long>

    @Update
    suspend fun update(item: ExampleEntity)

    @Update
    suspend fun updateAll(items: List<ExampleEntity>)

    @Delete
    suspend fun delete(item: ExampleEntity)

    @Delete
    suspend fun deleteAll(items: List<ExampleEntity>)

    @Query("SELECT * FROM example WHERE id = :id")
    fun getById(id: Long): Flow<ExampleEntity?>

    @Query("SELECT * FROM example ORDER BY createdAt DESC")
    fun getAll(): Flow<List<ExampleEntity>>

    @Query("DELETE FROM example WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM example")
    suspend fun clearAll()
}
