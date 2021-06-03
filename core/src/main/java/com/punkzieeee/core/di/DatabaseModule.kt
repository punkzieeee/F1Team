package com.punkzieeee.core.di

import android.content.Context
import androidx.room.Room
import com.punkzieeee.core.data.source.local.room.F1Dao
import com.punkzieeee.core.data.source.local.room.F1Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): F1Database {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("punkzieeee".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            F1Database::class.java, "F1Team.db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory).build()
    }

    @Provides
    fun provideTourismDao(database: F1Database): F1Dao = database.f1Dao()
}