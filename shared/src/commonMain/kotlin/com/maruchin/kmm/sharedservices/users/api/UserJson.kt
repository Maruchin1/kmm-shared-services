package com.maruchin.kmm.sharedservices.users.api

import com.maruchin.kmm.sharedservices.users.data.User
import kotlinx.serialization.Serializable

@Serializable
internal data class UserJson(val id: Long, val name: String, val email: String)

internal fun UserJson.asModel() = User(id = id, name = name, email = email)
