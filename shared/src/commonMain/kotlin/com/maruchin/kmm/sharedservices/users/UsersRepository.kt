package com.maruchin.kmm.sharedservices.users

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

internal class UsersRepository(private val usersApi: UsersApi) : Mutex by Mutex() {

    private val users = mutableMapOf<Long, User?>()

    suspend fun getUser(id: Long): User? {
        if (!users.containsKey(id)) {
            val apiUser = usersApi.fetchUser(id)?.asModel()
            if (apiUser != null) {
                withLock { users[id] = apiUser }
            }
        }
        return users[id]
    }

    suspend fun findUser(email: String): User? {
        var matchingUser = users.values.find { it?.email == email }
        if (matchingUser == null) {
            matchingUser = usersApi.fetchUserByEmail(email).firstOrNull()?.asModel()
            if (matchingUser != null) {
                withLock { users[matchingUser.id] = matchingUser }
            }
        }
        return matchingUser
    }
}
