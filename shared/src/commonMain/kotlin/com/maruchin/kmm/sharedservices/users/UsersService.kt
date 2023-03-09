package com.maruchin.kmm.sharedservices.users

import com.maruchin.kmm.sharedservices.session.Session
import com.maruchin.kmm.sharedservices.session.SessionRepository

class UsersService internal constructor(
    private val usersRepository: UsersRepository,
    private val sessionRepository: SessionRepository,
) {

    @Throws(Exception::class)
    suspend fun getLoggedUser(): User? {
        return sessionRepository.getSession()?.let { session ->
            usersRepository.getUser(session.loggedUserId)
        }
    }

    @Throws(Exception::class)
    suspend fun loginUser(email: String) {
        usersRepository.findUser(email)?.let { user ->
            val session = Session.forUser(user)
            sessionRepository.saveSession(session)
        }
    }

    @Throws(Exception::class)
    suspend fun logoutUser() {
        sessionRepository.saveSession(null)
    }
}
