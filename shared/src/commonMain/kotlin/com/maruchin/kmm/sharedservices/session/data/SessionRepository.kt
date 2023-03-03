package com.maruchin.kmm.sharedservices.session.data

import com.maruchin.kmm.sharedservices.session.storage.SessionStorage

internal class SessionRepository(private val sessionStorage: SessionStorage) {

    suspend fun getSession(): Session? {
        return sessionStorage.getSession()
    }

    suspend fun saveSession(session: Session?) {
        sessionStorage.saveSession(session)
    }
}
