package com.dungz.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dungz.data.local.dao.ExampleDao
import com.dungz.data.local.entity.ExampleEntity

/**
 * Main application database.
 * TODO: Add all entities and DAOs here
 */
@Database(
    entities = [
        ExampleEntity::class
        // TODO: Add your entities here
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
    // TODO: Add your DAOs here
}
