package com.clean.network.injection

import com.clean.network.source.post.UserDataSourceImpl
import com.clean.network.source.user.PostDataSourceImpl
import com.clean.repository.source.remote.RemotePostDataSource
import com.clean.repository.source.remote.RemoteUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(postDataSourceImpl: PostDataSourceImpl): RemotePostDataSource

    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: UserDataSourceImpl): RemoteUserDataSource
}