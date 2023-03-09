package com.maruchin.kmm.sharedservices.session

import com.maruchin.kmm.sharedservices.core.coreModule
import com.maruchin.kmm.sharedservices.core.fakeCoreDependenciesModule
import com.maruchin.kmm.sharedservices.sampleUsers
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
internal class SessionStorageTest : KoinTest {
    private val sessionStorage: SessionStorage by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(sessionModule, fakeCoreDependenciesModule, coreModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Session not saved`() = runTest {
        val session = sessionStorage.getSession()

        assertNull(session)
    }

    @Test
    fun `Session saved`() = runTest {
        val newSession = Session.forUser(sampleUsers[0])
        sessionStorage.saveSession(newSession)
        val session = sessionStorage.getSession()

        assertEquals(newSession, session)
    }

    @Test
    fun `Session changed to different one`() = runTest {
        val firstSession = Session.forUser(sampleUsers[0])
        sessionStorage.saveSession(firstSession)
        val secondSession = Session.forUser(sampleUsers[2])
        sessionStorage.saveSession(secondSession)
        val session = sessionStorage.getSession()

        assertEquals(secondSession, session)
    }
}
