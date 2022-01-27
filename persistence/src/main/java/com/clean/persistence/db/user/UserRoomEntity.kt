package com.clean.persistence.db.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clean.domain.entities.User

@Entity(tableName = "user")
data class UserRoomEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "email") val email: String
){

    fun toUser() = User(id, name, username, email)

    companion object {

        fun fromUser(user: User) = UserRoomEntity(user.id, user.name, user.username, user.email)
    }
}