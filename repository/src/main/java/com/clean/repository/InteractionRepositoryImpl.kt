package com.clean.repository

import com.clean.domain.entities.Interaction
import com.clean.domain.repository.InteractionRepository
import com.clean.repository.source.local.LocalInteractionDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class InteractionRepositoryImpl @Inject constructor(private val interactionDataSource: LocalInteractionDataSource) :
    InteractionRepository {

    override fun getInteraction(): Flow<Interaction> = interactionDataSource.getInteraction()

    override fun saveInteraction(interaction: Interaction): Flow<Interaction> = flow<Nothing> {
        interactionDataSource.saveInteraction(interaction)
    }.flatMapLatest {
        getInteraction()
    }
}