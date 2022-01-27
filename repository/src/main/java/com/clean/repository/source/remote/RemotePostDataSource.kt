package com.clean.repository.source.remote

import com.clean.domain.entities.Post
import kotlinx.coroutines.flow.Flow

interface RemotePostDataSource {

    fun getPosts(): Flow<List<Post>>

    fun getPost(id: Long): Flow<Post>
}