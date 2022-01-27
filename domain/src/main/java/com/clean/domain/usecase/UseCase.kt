package com.clean.domain.usecase

import com.clean.domain.entities.UseCaseException
import com.clean.domain.entities.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*

abstract class UseCase<I : UseCase.Request, O : UseCase.Response>
    (private val configuration: Configuration) {

    fun execute(request: I) = executeInternal(request)
        .map {
            Result.Success(it) as Result<O>
        }
        .flowOn(configuration.dispatcher)
        .catch {
            emit(Result.Error(UseCaseException.createFromThrowable(it)))
        }

    internal abstract fun executeInternal(request: I): Flow<O>

    class Configuration(val dispatcher: CoroutineDispatcher)

    interface Request

    interface Response
}
