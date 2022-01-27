package com.clean.domain.usecase

import com.clean.domain.entities.User
import com.clean.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserUseCase @Inject constructor(
    configuration: Configuration,
    private val userRepository: UserRepository
) : UseCase<UserUseCase.Request, UserUseCase.Response>(configuration) {

    override fun executeInternal(request: Request): Flow<Response> =
        userRepository.getUser(request.userId)
            .map {
                Response(it)
            }

    data class Request(val userId: Long) : UseCase.Request
    data class Response(val user: User) : UseCase.Response
}