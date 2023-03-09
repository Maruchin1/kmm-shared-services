package com.maruchin.kmm.sharedservices.session

internal class SessionRepository(private val sessionStorage: SessionStorage) {

    fun getSession(): Session? {
        return sessionStorage.getSession()
    }

    fun saveSession(session: Session?) {
        sessionStorage.saveSession(session)
    }
}
