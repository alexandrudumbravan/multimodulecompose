package com.clean.repository

import com.clean.domain.entities.User
import com.clean.domain.repository.UserRepository
import com.clean.repository.source.local.LocalUserDataSource
import com.clean.repository.source.remote.RemoteUserDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val localUserDataSource: LocalUserDataSource
) : UserRepository {

    override fun getUsers(): Flow<List<User>> = remoteUserDataSource.getUsers()
        .onEach {
            localUserDataSource.addUsers(it)
        }

    override fun getUser(id: Long): Flow<User> = remoteUserDataSource.getUser(id)
        .onEach {
            localUserDataSource.addUsers(listOf(it))
        }

}