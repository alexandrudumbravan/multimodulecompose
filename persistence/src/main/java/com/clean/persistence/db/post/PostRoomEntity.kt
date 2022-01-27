package com.clean.persistence.db.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clean.domain.entities.Post

@Entity(tableName = "post")
data class PostRoomEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "userId") val userId: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "body") val body: String
) {
    fun toPost() = Post(id, userId, title, body)

    companion object {

        fun fromPost(post: Post) = PostRoomEntity(post.id, post.userId, post.title, post.body)
    }
}