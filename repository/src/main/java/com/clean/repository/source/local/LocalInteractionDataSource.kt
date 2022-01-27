package com.clean.repository.source.local

import com.clean.domain.entities.Interaction
import kotlinx.coroutines.flow.Flow

interface LocalInteractionDataSource {

    fun getInteraction(): Flow<Interaction>

    suspend fun saveInteraction(interaction: Interaction)
}