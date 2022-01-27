package com.clean.repository.source.remote

import com.clean.domain.entities.User
import kotlinx.coroutines.flow.Flow

interface RemoteUserDataSource {

    fun getUsers(): Flow<List<User>>

    fun getUser(id: Long): Flow<User>
}