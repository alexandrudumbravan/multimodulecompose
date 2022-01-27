package com.clean.presentation_common

import com.clean.domain.entities.Result
import com.clean.domain.entities.UseCaseException
import com.clean.domain.usecase.UseCase

sealed class PresentedResult<out T> {
    object Loading : PresentedResult<Nothing>()
    data class Success<out T>(val data: T) : PresentedResult<T>()
    data class Error(val errorMessage: String) : PresentedResult<Nothing>()

    companion object {

        fun <I : UseCase.Response, O> fromResult(
            result: Result<I>,
            mapper: (I) -> O,
            errorMapper: (UseCaseException) -> String = {
                ""
            }
        ): PresentedResult<O> {
            return when (result) {
                is Result.Success -> Success(mapper(result.data))
                is Result.Error -> Error(errorMapper(result.exception))
            }
        }
    }
}