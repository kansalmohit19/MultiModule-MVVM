package com.example.data.extensions

import com.example.data.model.CommonResponse
import com.example.domain.core.Either
import com.example.domain.core.IFailure
import com.example.domain.core.Unknown
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend inline fun <T, X> safeApiCall(
    crossinline apiCall: suspend () -> T, successTransform: (T?) -> X
): Either<X, IFailure> {
    val response = withContext(Dispatchers.IO) { apiCall.invoke() }
    if (response is Response<*>) {
        if (response.code() >= 400) {
            return Either.Error(Unknown("Some error occurred"))
        } else {
            val parsedResponse = response.body().getResponse(CommonResponse::class.java)
            if (parsedResponse?.statusCode == 200) {
                return Either.Success(successTransform(response))
            } else {
                return Either.Error(Unknown("Some error occurred"))
            }
        }
    }
    return Either.Error(Unknown("Some error occurred"))
}

fun <T> T.getResponse(classRef: Class<CommonResponse<*>>): CommonResponse<*>? {
    return Gson().fromJson(Gson().toJson(this), classRef)
}