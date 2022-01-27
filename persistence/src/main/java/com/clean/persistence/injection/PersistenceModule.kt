package com.clean.persistence.injection

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.clean.persistence.datastore.InteractionDataStore
import com.clean.persistence.db.AppDatabase
import com.clean.persistence.db.post.PostRoomDao
import com.clean.persistence.db.user.UserRoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_preferences")

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "my-database"
        ).build()

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserRoomDao = appDatabase.userDao()

    @Provides
    fun providePostDao(appDatabase: AppDatabase): PostRoomDao = appDatabase.postDao()

    @Provides
    fun provideInteractionDataStore(@ApplicationContext context: Context) =
        InteractionDataStore(context.dataStore)
}