package com.maruchin.kmm.architecture.sharedlogic.session.data

import com.maruchin.kmm.architecture.sharedlogic.users.data.User

internal data class Session(val loggedUserId: Long) {

    companion object {

        fun forUser(user: User) = Session(loggedUserId = user.id)
    }
}
