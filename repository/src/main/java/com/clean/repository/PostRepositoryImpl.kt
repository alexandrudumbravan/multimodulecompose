package com.clean.repository

import com.clean.domain.entities.Post
import com.clean.domain.repository.PostRepository
import com.clean.repository.source.local.LocalPostDataSource
import com.clean.repository.source.remote.RemotePostDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remotePostDataSource: RemotePostDataSource,
    private val localPostDataSource: LocalPostDataSource
) : PostRepository {

    override fun getPosts(): Flow<List<Post>> = remotePostDataSource.getPosts()
        .onEach {
            localPostDataSource.addPosts(it)
        }

    override fun getPost(id: Long): Flow<Post> = remotePostDataSource.getPost(id)
        .onEach {
            localPostDataSource.addPosts(listOf(it))
        }
}