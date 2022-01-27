package com.clean.presentation_post.list

import android.content.Context
import com.clean.domain.entities.Result
import com.clean.domain.usecase.PostsUsersUseCase
import com.clean.presentation_common.PresentedResult
import com.clean.presentation_post.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PostListConverter @Inject constructor(@ApplicationContext private val context: Context) {


    fun convert(postListResult: Result<PostsUsersUseCase.Response>): PresentedResult<PostListModel> {
        return PresentedResult.fromResult(postListResult, { response ->
            PostListModel(
                headerText = context.getString(
                    R.string.total_click_count,
                    response.interaction.totalTaps
                ),
                interaction = response.interaction,
                items = response.posts.map {
                    PostListItemModel(
                        it.post.id,
                        context.getString(R.string.author, it.user.name),
                        context.getString(R.string.title, it.post.title)
                    )
                }
            )
        }, {
            it.localizedMessage.orEmpty()
        })
    }
}