package com.clean.presentation_post.list

import com.clean.domain.entities.Interaction

data class PostListModel(
    val headerText: String = "",
    val interaction: Interaction,
    val items: List<PostListItemModel> = listOf()
)

data class PostListItemModel(
    val id: Long,
    val authorName: String,
    val title: String
)