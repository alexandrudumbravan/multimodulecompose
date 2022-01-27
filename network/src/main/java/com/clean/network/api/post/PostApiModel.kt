package com.clean.network.api.post

import com.clean.domain.entities.Post
import com.squareup.moshi.Json

data class PostApiModel(
    @Json(name = "id") val id: Long,
    @Json(name = "userId") val userId: Long,
    @Json(name = "title") val title: String,
    @Json(name = "body") val body: String
) {


    fun toPost() = Post(id, userId, title, body)

    companion object {

        fun fromPost(post: Post) = PostApiModel(post.id, post.userId, post.title, post.body)
    }
}