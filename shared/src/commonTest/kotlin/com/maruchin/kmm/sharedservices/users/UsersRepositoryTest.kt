package com.maruchin.kmm.sharedservices.users

import com.maruchin.kmm.sharedservices.core.FakeHttpEngine
import com.maruchin.kmm.sharedservices.core.coreModule
import com.maruchin.kmm.sharedservices.core.fakeCoreDependenciesModule
import com.maruchin.kmm.sharedservices.sampleUsers
import com.maruchin.kmm.sharedservices.sampleUsersJson
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
    private val fakeHttpEngine: FakeHttpEngine by inject()
    private val usersRepository: UsersRepository by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(usersModule, fakeCoreDependenciesModule, coreModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get user`() = runTest {
        fakeHttpEngine.mockUser(sampleUsersJson[1])
        val user = usersRepository.getUser(sampleUsers[1].id)

        assertEquals(sampleUsers[1], user)
    }

    @Test
    fun `Find user`() = runTest {
        fakeHttpEngine.mockUserByEmail(sampleUsersJson[2])
        val user = usersRepository.findUser(sampleUsers[2].email)

        assertEquals(sampleUsers[2], user)
    }
}
