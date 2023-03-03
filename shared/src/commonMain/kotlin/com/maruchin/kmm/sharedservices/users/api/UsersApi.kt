package com.maruchin.kmm.sharedservices.users.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class UsersApi(private val client: HttpClient) {

    suspend fun fetchUser(id: Long): UserJson? {
        return client.get("https://jsonplaceholder.typicode.com/users/$id").body()
    }

    suspend fun fetchUserByEmail(email: String): List<UserJson> {
        return client.get("https://jsonplaceholder.typicode.com/users") {
            url {
                parameters.append("email", email)
            }
        }.body()
    }
}
