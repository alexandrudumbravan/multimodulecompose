package com.clean.persistence.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.clean.domain.entities.Interaction
import com.clean.repository.source.local.LocalInteractionDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val KEY_TOTAL_TAPS = intPreferencesKey("key_total_taps")

class InteractionDataStore(private val dataStore: DataStore<Preferences>) :
    LocalInteractionDataSource {

    override fun getInteraction(): Flow<Interaction> {
        return dataStore.data.map {
            Interaction(it[KEY_TOTAL_TAPS] ?: 0)
        }
    }

    override suspend fun saveInteraction(interaction: Interaction) {
        dataStore.edit {
            it[KEY_TOTAL_TAPS] = interaction.totalTaps
        }
    }

}