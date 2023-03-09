package com.maruchin.kmm.sharedservices.session

internal class SessionRepository(private val sessionStorage: SessionStorage) {

    suspend fun getSession(): Session? {
        return sessionStorage.getSession()
    }

    suspend fun saveSession(session: Session?) {
        sessionStorage.saveSession(session)
    }
}
