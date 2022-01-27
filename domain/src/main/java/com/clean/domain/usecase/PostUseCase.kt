package com.clean.domain.usecase

import com.clean.domain.entities.Post
import com.clean.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostUseCase @Inject constructor(
    configuration: Configuration,
    private val postRepository: PostRepository
) :
    UseCase<PostUseCase.Request, PostUseCase.Response>(configuration) {

    override fun executeInternal(request: Request): Flow<Response> =
        postRepository.getPost(request.postId)
            .map {
                Response(it)
            }


    data class Request(val postId: Long) : UseCase.Request
    data class Response(val post: Post) : UseCase.Response
}