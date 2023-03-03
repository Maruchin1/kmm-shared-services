package com.maruchin.kmm.sharedservices.session.storage

import com.maruchin.kmm.sharedservices.session.data.Session
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

private const val LOGGED_USER_ID = "logged_user_id"

internal class SessionStorage(
    private val settings: Settings,
    private val dispatcher: CoroutineDispatcher,
) {

    suspend fun getSession(): Session? = withContext(dispatcher) {
        settings
            .getLongOrNull(LOGGED_USER_ID)
            ?.let { Session(it) }
    }

    suspend fun saveSession(session: Session?) = withContext(dispatcher) {
        settings[LOGGED_USER_ID] = session?.loggedUserId
    }
}
