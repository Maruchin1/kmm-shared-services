package com.maruchin.kmm.sharedservices.users

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

internal class UsersRepository(private val usersApi: UsersApi) : Mutex by Mutex() {
    private val users = mutableMapOf<Long, User?>()

    suspend fun getUser(id: Long): User? {
        return users[id] ?: kotlin.run {
            usersApi.fetchUser(id)?.asModel()?.also { user ->
                withLock { users[id] = user }
            }
        }
    }

    suspend fun findUser(email: String): User? {
        return users.values.find { it?.email == email } ?: kotlin.run {
            usersApi.fetchUserByEmail(email).firstOrNull()?.asModel()?.also { user ->
                withLock { users[user.id] = user }
            }
        }
    }
}
