package com.maruchin.kmm.sharedservices.users

import com.maruchin.kmm.sharedservices.sampleUsersJson

internal class FakeUsersApi : UsersApi {

    var users: List<UserJson> = sampleUsersJson

    override suspend fun fetchUser(id: Long): UserJson? {
        return users.find { it.id == id }
    }

    override suspend fun fetchUserByEmail(email: String): List<UserJson> {
        return users.filter { it.email == email }
    }
}
