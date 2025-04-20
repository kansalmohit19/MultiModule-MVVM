package com.example.data.extensions

import com.example.common.Constants.CONST_200
import com.example.common.Constants.CONST_400
import com.example.data.model.CommonResponse
import com.example.domain.core.Either
import com.example.domain.core.IFailure
import com.example.domain.core.Unknown
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend inline fun <T, X> safeApiCall(
    crossinline apiCall: suspend () -> T,
    successTransform: (T?) -> X
): Either<X, IFailure> {
    val result: Either<X, IFailure>
    val response = withContext(Dispatchers.IO) { apiCall.invoke() }

    result = if (response is Response<*>) {
        if (response.code() >= CONST_400) {
            Either.Error(Unknown("Some error occurred"))
        } else {
            val parsedResponse = response.body()
                ?.getResponse(CommonResponse::class.java)
            if (parsedResponse?.statusCode == CONST_200) {
                Either.Success(successTransform(response))
            } else {
                Either.Error(Unknown("Some error occurred"))
            }
        }
    } else {
        Either.Error(Unknown("Some error occurred"))
    }

    return result
}

fun <T> T.getResponse(classRef: Class<CommonResponse<*>>): CommonResponse<*>? {
    return Gson().fromJson(Gson().toJson(this), classRef)
}
