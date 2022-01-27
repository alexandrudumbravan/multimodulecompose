package com.clean.network.api.user

import com.clean.domain.entities.User
import com.squareup.moshi.Json

data class UserApiModel(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "username") val username: String,
    @Json(name = "email") val email: String
) {

    fun toUser() = User(id, name, username, email)

    companion object {

        fun fromUser(user: User) = UserApiModel(user.id, user.name, user.username, user.email)
    }
}