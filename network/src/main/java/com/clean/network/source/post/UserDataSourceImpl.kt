package com.clean.network.source.post

import com.clean.domain.entities.UseCaseException
import com.clean.domain.entities.User
import com.clean.network.api.user.UserService
import com.clean.repository.source.remote.RemoteUserDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(private val userService: UserService) :
    RemoteUserDataSource {

    override fun getUsers(): Flow<List<User>> = flow {
        emit(userService.getUsers())
    }.map { users ->
        users.map { userApiModel ->
            userApiModel.toUser()
        }
    }.catch {
        throw UseCaseException.UserException(it)
    }

    override fun getUser(id: Long): Flow<User> = flow {
        emit(userService.getUser(id))
    }.map {
        it.toUser()
    }.catch {
        throw UseCaseException.UserException(it)
    }
}