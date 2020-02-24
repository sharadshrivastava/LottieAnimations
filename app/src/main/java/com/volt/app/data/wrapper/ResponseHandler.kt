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
                ErrorCodes.UN_AUTH.code -> VoltApp.get().getString(R.string.unauthorized)
                ErrorCodes.NOT_FOUND.code -> VoltApp.get().getString(R.string.not_found)
                ErrorCodes.INTERNAL_ERR.code -> VoltApp.get().getString(R.string.internal_err)
                ErrorCodes.SVC_UN_AVAIL.code -> VoltApp.get().getString(R.string.svc_un_avail)
                else -> VoltApp.get().getString(R.string.response_error)
            }
        }
    }

    enum class ErrorCodes(val code: Int) {
        UN_AUTH(401),
        NOT_FOUND(404),
        INTERNAL_ERR(500),
        SVC_UN_AVAIL(503)
    }
}