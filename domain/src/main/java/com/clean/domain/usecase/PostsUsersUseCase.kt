package com.clean.domain.usecase

import com.clean.domain.entities.Interaction
import com.clean.domain.entities.PostUser
import com.clean.domain.repository.InteractionRepository
import com.clean.domain.repository.PostRepository
import com.clean.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.combineTransform
import javax.inject.Inject

class PostsUsersUseCase @Inject constructor(
    configuration: Configuration,
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
    private val interactionRepository: InteractionRepository
) : UseCase<PostsUsersUseCase.Request, PostsUsersUseCase.Response>(configuration) {

    override fun executeInternal(request: Request): Flow<Response> =
        combine(
            postRepository.getPosts(),
            userRepository.getUsers(),
            interactionRepository.getInteraction()
        ) { posts, users, interaction ->
            val postUsers = posts.map { post ->
                val user = users.first {
                    it.id == post.userId
                }
                PostUser(post, user)
            }
            Response(postUsers, interaction)
        }

    object Request : UseCase.Request

    data class Response(
        val posts: List<PostUser>,
        val interaction: Interaction
    ) : UseCase.Response
}