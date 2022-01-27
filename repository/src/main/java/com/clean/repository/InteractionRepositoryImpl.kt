package com.clean.repository

import com.clean.domain.entities.Interaction
import com.clean.domain.repository.InteractionRepository
import com.clean.repository.source.local.LocalInteractionDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InteractionRepositoryImpl @Inject constructor(private val interactionDataSource: LocalInteractionDataSource) :
    InteractionRepository {

    override fun getInteraction(): Flow<Interaction> = interactionDataSource.getInteraction()

    override suspend fun saveInteraction(interaction: Interaction) {
        interactionDataSource.saveInteraction(interaction)
    }
}