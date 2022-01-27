package com.clean.repository.injection

import com.clean.domain.repository.InteractionRepository
import com.clean.domain.repository.PostRepository
import com.clean.domain.repository.UserRepository
import com.clean.repository.InteractionRepositoryImpl
import com.clean.repository.PostRepositoryImpl
import com.clean.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindInteractionRepository(interactionRepositoryImpl: InteractionRepositoryImpl): InteractionRepository
}