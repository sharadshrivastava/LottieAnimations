package com.volt.app.data.model

import com.squareup.moshi.Json

data class LoginRequest(

    @Json(name = "code")
    val code: String? = null
)