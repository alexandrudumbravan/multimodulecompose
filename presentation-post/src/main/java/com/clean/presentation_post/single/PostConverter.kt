package com.clean.presentation_post.single

import android.content.Context
import com.clean.domain.entities.Result
import com.clean.domain.usecase.PostUseCase
import com.clean.presentation_common.PresentedResult
import com.clean.presentation_post.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PostConverter @Inject constructor(@ApplicationContext private val context: Context) {

    fun convert(postResult: Result<PostUseCase.Response>): PresentedResult<PostModel> {
        return PresentedResult.fromResult(postResult, {
            PostModel(
                context.getString(R.string.title, it.post.title),
                context.getString(R.string.body, it.post.body)
            )
        }, {
            it.localizedMessage.orEmpty()
        })
    }

}