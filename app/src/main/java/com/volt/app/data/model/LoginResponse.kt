package com.volt.app.data.model

import com.squareup.moshi.Json

data class LoginResponse(

	@Json(name="status")
	val status: String? = null
)