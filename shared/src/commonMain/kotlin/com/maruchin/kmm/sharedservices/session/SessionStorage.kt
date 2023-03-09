package com.maruchin.kmm.sharedservices.session

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

private const val LOGGED_USER_ID = "logged_user_id"

internal class SessionStorage(private val settings: Settings) {

    fun getSession(): Session? {
        return settings
            .getLongOrNull(LOGGED_USER_ID)
            ?.let { Session(it) }
    }

    fun saveSession(session: Session?) {
        settings[LOGGED_USER_ID] = session?.loggedUserId
    }
}
