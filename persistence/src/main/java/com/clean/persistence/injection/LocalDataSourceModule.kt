package com.clean.persistence.injection

import com.clean.persistence.datastore.InteractionDataStore
import com.clean.persistence.db.post.PostDataSourceImpl
import com.clean.persistence.db.user.UserDataSourceImpl
import com.clean.repository.source.local.LocalInteractionDataSource
import com.clean.repository.source.local.LocalPostDataSource
import com.clean.repository.source.local.LocalUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(lostDataSourceImpl: PostDataSourceImpl): LocalPostDataSource

    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: UserDataSourceImpl): LocalUserDataSource

    @Binds
    abstract fun bindInteractionDataStore(interactionDataStore: InteractionDataStore): LocalInteractionDataSource
}