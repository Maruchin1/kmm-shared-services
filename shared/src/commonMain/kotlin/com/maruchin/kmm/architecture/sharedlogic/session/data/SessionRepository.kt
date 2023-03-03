package com.maruchin.kmm.architecture.sharedlogic.session.data

import com.maruchin.kmm.architecture.sharedlogic.session.storage.SessionStorage

internal class SessionRepository(private val sessionStorage: SessionStorage) {

    suspend fun getSession(): Session? {
        return sessionStorage.getSession()
    }

    suspend fun saveSession(session: Session?) {
        sessionStorage.saveSession(session)
    }
}
