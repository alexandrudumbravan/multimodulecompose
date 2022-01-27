package com.clean.persistence.db.user

import com.clean.domain.entities.User
import com.clean.repository.source.local.LocalUserDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(private val userRoomDao: UserRoomDao)
    : LocalUserDataSource {

    override fun getUsers(): Flow<List<User>> = userRoomDao.getUsers().map { users ->
        users.map {
            it.toUser()
        }
    }

    override suspend fun addUsers(users: List<User>) = userRoomDao.insertUsers(users.map {
        UserRoomEntity.fromUser(it)
    })
}