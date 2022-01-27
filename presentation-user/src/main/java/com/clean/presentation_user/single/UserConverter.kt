package com.clean.presentation_user.single

import android.content.Context
import com.clean.domain.entities.Result
import com.clean.domain.usecase.UserUseCase
import com.clean.presentation_common.PresentedResult
import com.clean.presentation_user.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserConverter @Inject constructor(@ApplicationContext private val context: Context) {

    fun convert(userResult: Result<UserUseCase.Response>): PresentedResult<UserModel> {
        return PresentedResult.fromResult(userResult, {
            UserModel(
                context.getString(R.string.name, it.user.name),
                context.getString(R.string.username, it.user.username),
                context.getString(R.string.email, it.user.email)
            )
        }, {
            it.localizedMessage.orEmpty()
        })
    }

}