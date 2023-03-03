package com.maruchin.kmm.architecture.sharedlogic.users

import com.maruchin.kmm.architecture.sharedlogic.session.data.Session
import com.maruchin.kmm.architecture.sharedlogic.session.data.SessionRepository
import com.maruchin.kmm.architecture.sharedlogic.users.data.UsersRepository

class UsersService internal constructor(
    private val usersRepository: UsersRepository,
    private val sessionRepository: SessionRepository,
) {

    @Throws(Exception::class)
    suspend fun loginUser(email: String) {
        val user = usersRepository.findUser(email) ?: throw UserNotFoundException()
        val session = Session.forUser(user)
        sessionRepository.saveSession(session)
    }

    @Throws(Exception::class)
    suspend fun logoutUser() {
        sessionRepository.saveSession(null)
    }
}
