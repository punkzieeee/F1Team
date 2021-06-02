package com.punkzieeee.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.punkzieeee.core.data.source.local.entity.F1Entity

@Database(entities = [F1Entity::class],
    version = 1,
    exportSchema = false)
abstract class F1Database : RoomDatabase() {
    abstract fun f1Dao(): F1Dao
}