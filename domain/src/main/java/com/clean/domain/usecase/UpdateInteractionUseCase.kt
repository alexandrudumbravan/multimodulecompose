package com.clean.domain.usecase

import com.clean.domain.entities.Interaction
import com.clean.domain.repository.InteractionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateInteractionUseCase @Inject constructor(
    configuration: Configuration,
    private val interactionRepository: InteractionRepository
) : UseCase<UpdateInteractionUseCase.Request, UpdateInteractionUseCase.Response>(configuration) {

    override fun executeInternal(request: Request): Flow<Response> {
        return flow {
            interactionRepository.saveInteraction(request.interaction)
            emit(Response)
        }
    }

    data class Request(val interaction: Interaction) : UseCase.Request

    object Response : UseCase.Response
}