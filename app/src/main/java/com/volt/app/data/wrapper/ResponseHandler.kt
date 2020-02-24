package com.volt.app.data.wrapper

import com.volt.app.R
import com.volt.app.VoltApp
import retrofit2.HttpException
import java.net.SocketTimeoutException

open class ResponseHandler {

    companion object {
        fun <T : Any> handleSuccess(data: T): Resource<T> {
            return Resource.success(data)
        }

        fun <T : Any> handleException(e: Exception): Resource<T> {
            return when (e) {
                is HttpException -> Resource.error(
                    getErrorMessage(
                        e.code()
                    ), null)
                is SocketTimeoutException -> Resource.error(VoltApp.get().getString(R.string.timeout), null)
                else -> Resource.error(
                    getErrorMessage(
                        Int.MAX_VALUE
                    ), null)
            }
        }

        private fun getErrorMessage(code: Int): String {
            return when (code) {
                401 -> VoltApp.get().getString(R.string.unauthorized)
                404 -> VoltApp.get().getString(R.string.not_found)
                else -> VoltApp.get().getString(R.string.response_error)
            }
        }
    }
}