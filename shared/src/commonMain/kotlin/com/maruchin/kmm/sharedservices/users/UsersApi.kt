package com.maruchin.kmm.sharedservices.users

internal interface UsersApi {
    suspend fun fetchUser(id: Long): UserJson?
    suspend fun fetchUserByEmail(email: String): List<UserJson>
}
