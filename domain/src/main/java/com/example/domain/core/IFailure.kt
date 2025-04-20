package com.example.domain.core

interface IFailure {
    val errorMessage: String
}

data class Network(override val errorMessage: String) : IFailure
data class Server(override val errorMessage: String) : IFailure
data class Unknown(override val errorMessage: String) : IFailure
