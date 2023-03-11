package com.maruchin.kmm.sharedservices.users

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

@OptIn(ExperimentalCoroutinesApi::class)
internal class UsersRepositoryTest : KoinTest {
    private val usersRepository: UsersRepository by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(usersModule, testModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get user`() = runTest {
        // when
        val user = usersRepository.getUser(sampleUsers[1].id)

        // then
        assertEquals(sampleUsers[1], user)
    }

    @Test
    fun `Find user`() = runTest {
        // when
        val user = usersRepository.findUser(sampleUsers[2].email)

        // then
        assertEquals(sampleUsers[2], user)
    }
}
