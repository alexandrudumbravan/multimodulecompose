package com.clean.domain.repository

import com.clean.domain.entities.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPosts(): Flow<List<Post>>

    fun getPost(id: Long): Flow<Post>
}