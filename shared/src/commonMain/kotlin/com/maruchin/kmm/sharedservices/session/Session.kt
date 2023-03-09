package com.maruchin.kmm.sharedservices.session

import com.maruchin.kmm.sharedservices.users.User

internal data class Session(val loggedUserId: Long) {

    companion object {

        fun forUser(user: User) = Session(loggedUserId = user.id)
    }
}
