package com.clean.network.source.user

import com.clean.domain.entities.Post
import com.clean.domain.entities.UseCaseException
import com.clean.network.api.post.PostService
import com.clean.repository.source.remote.RemotePostDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(private val postService: PostService) :
    RemotePostDataSource {

    override fun getPosts(): Flow<List<Post>> = flow {
        emit(postService.getPosts())
    }.map { posts ->
        posts.map { postApiModel ->
            postApiModel.toPost()
        }
    }.catch {
        throw UseCaseException.PostException(it)
    }

    override fun getPost(id: Long): Flow<Post> = flow {
        emit(postService.getPost(id))
    }.map {
        it.toPost()
    }.catch {
        throw UseCaseException.PostException(it)
    }
}