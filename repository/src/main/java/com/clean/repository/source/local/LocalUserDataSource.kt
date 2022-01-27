package com.clean.repository.source.local

import com.clean.domain.entities.User
import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {

    fun getUsers(): Flow<List<User>>

    suspend fun addUsers(users: List<User>)
}