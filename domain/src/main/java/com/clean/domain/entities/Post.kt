package com.clean.domain.entities

data class Post(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)

data class PostUser(
    val post: Post,
    val user: User
)