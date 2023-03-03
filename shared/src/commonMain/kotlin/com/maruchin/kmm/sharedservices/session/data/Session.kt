package com.maruchin.kmm.sharedservices.session.data

import com.maruchin.kmm.sharedservices.users.data.User

internal data class Session(val loggedUserId: Long) {

    companion object {

        fun forUser(user: User) = Session(loggedUserId = user.id)
    }
}
