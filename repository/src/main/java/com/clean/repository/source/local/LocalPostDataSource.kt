package com.clean.repository.source.local

import com.clean.domain.entities.Post
import kotlinx.coroutines.flow.Flow

interface LocalPostDataSource {

    fun getPosts(): Flow<List<Post>>

    suspend fun addPosts(posts: List<Post>)
}