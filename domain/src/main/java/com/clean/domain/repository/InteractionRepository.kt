package com.clean.domain.repository

import com.clean.domain.entities.Interaction
import kotlinx.coroutines.flow.Flow

interface InteractionRepository {

    fun getInteraction(): Flow<Interaction>

    suspend fun saveInteraction(interaction: Interaction)
}