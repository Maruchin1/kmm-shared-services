package com.maruchin.kmm.sharedservices.session

import com.maruchin.kmm.sharedservices.sampleUsers
import com.maruchin.kmm.sharedservices.testModule
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
class SessionRepositoryTest : KoinTest {
    private val sessionRepository: SessionRepository by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(sessionModule, testModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Session not saved`() = runTest {
        // when
        val session = sessionRepository.getSession()

        // then
        assertNull(session)
    }

    @Test
    fun `Session saved`() = runTest {
        // when
        val newSession = Session.forUser(sampleUsers[0])
        sessionRepository.saveSession(newSession)
        val session = sessionRepository.getSession()

        // then
        assertEquals(newSession, session)
    }

    @Test
    fun `Session changed to different one`() = runTest {
        // when
        val firstSession = Session.forUser(sampleUsers[0])
        sessionRepository.saveSession(firstSession)
        val secondSession = Session.forUser(sampleUsers[2])
        sessionRepository.saveSession(secondSession)
        val session = sessionRepository.getSession()

        // then
        assertEquals(secondSession, session)
    }
}
