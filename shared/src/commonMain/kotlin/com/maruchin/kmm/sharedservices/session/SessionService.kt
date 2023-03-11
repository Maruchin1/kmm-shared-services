package com.maruchin.kmm.sharedservices.session

import com.maruchin.kmm.sharedservices.users.UsersRepository

class SessionService internal constructor(
    private val sessionRepository: SessionRepository,
    private val usersRepository: UsersRepository,
) {

    @Throws(Throwable::class)
    suspend fun loginUser(email: String) {
        val user = usersRepository.findUser(email)
        if (user != null) {
            val session = Session.forUser(user)
            sessionRepository.saveSession(session)
        }
    }

    @Throws(Throwable::class)
    suspend fun logoutUser() {
        sessionRepository.saveSession(null)
    }
}
