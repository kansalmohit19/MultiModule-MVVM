package com.example.core

sealed class Either<out S, out E> where S : Any? {

    data class Success<out S>(val successVal: S) : Either<S, Nothing>()
    data class Error<out E>(val errorVal: E) : Either<Nothing, E>()

    val isSuccess get() = this is Success<S>

    val isError get() = this is Error<E>

    fun either(fnR: (S) -> Any, fnL: (E) -> Any): Any = when (this) {
        is Success -> fnR(successVal)
        is Error -> fnL(errorVal)
    }

    fun errorValue() = if (this is Error) errorVal else null

    fun successValue() = if (this is Success) successVal else null
}
