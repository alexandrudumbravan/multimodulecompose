package com.clean.persistence.db.post

import com.clean.domain.entities.Post
import com.clean.repository.source.local.LocalPostDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(private val postDaoRoomDao: PostRoomDao)
    : LocalPostDataSource {

    override fun getPosts(): Flow<List<Post>> = postDaoRoomDao.getPosts().map { posts ->
        posts.map {
            it.toPost()
        }
    }

    override suspend fun addPosts(posts: List<Post>) = postDaoRoomDao.insertPosts(posts.map {
        PostRoomEntity.fromPost(it)
    })
}