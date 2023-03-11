package com.maruchin.kmm.sharedservices.session

import com.maruchin.kmm.sharedservices.sampleUsers
import com.maruchin.kmm.sharedservices.testModule
import com.maruchin.kmm.sharedservices.users.usersModule
import com.russhwolf.settings.Settings
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

@OptIn(ExperimentalCoroutinesApi::class)
class SessionServiceTest : KoinTest {
    private val settings: Settings by inject()
    private val sessionService: SessionService by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(sessionModule, usersModule, testModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Login user success`() = runTest {
        // when
        val user = sampleUsers[0]
        sessionService.loginUser(user.email)

        // then
        assertEquals(user.id, settings.getLongOrNull("logged_user_id"))
    }

    @Test
    fun `Login user with incorrect email`() = runTest {
        // when
        sessionService.loginUser("abc")

        // then
        assertNull(settings.getLongOrNull("logged_user_id"))
    }

    @Test
    fun `Logout user success`() = runTest {
        // when
        val user = sampleUsers[0]
        settings.putLong("logged_user_id", user.id)
        sessionService.logoutUser()

        // then
        assertNull(settings.getLongOrNull("logged_user_id"))
    }
}
