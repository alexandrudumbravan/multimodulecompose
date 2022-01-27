package com.clean.domain.entities

import com.clean.domain.usecase.UseCase

sealed class Result<out T : UseCase.Response> {
    data class Success<out T : UseCase.Response>(val data: T) : Result<T>()
    class Error(val exception: UseCaseException) : Result<Nothing>()
}