package com.example.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<in Params, out Type> where Type : Any? {

    abstract suspend fun run(params: Params): Either<Type, IFailure>

    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (Type) -> Unit = {},
        onFailure: (IFailure) -> Unit = {}
    ) {
        val job = scope.async { run(params) }
        scope.launch {
            job.await().either(onSuccess, onFailure)
        }
    }
}