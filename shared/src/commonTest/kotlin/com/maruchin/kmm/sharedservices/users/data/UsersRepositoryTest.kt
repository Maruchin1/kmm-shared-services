package com.maruchin.kmm.sharedservices.users.data

import com.maruchin.kmm.sharedservices.libs.libsModule
import com.maruchin.kmm.sharedservices.mock.HttpMock
import com.maruchin.kmm.sharedservices.mock.mocksModule
import com.maruchin.kmm.sharedservices.sampleUsers
import com.maruchin.kmm.sharedservices.sampleUsersJson
import com.maruchin.kmm.sharedservices.users.usersModule
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

    private val httpMock: HttpMock by inject()
    private val usersRepository: UsersRepository by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(libsModule, usersModule, mocksModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get user`() = runTest {
        httpMock.mockUser(sampleUsersJson[1])
        val user = usersRepository.getUser(sampleUsers[1].id)

        assertEquals(sampleUsers[1], user)
    }

    @Test
    fun `Find user`() = runTest {
        httpMock.mockUserByEmail(sampleUsersJson[2])
        val user = usersRepository.findUser(sampleUsers[2].email)

        assertEquals(sampleUsers[2], user)
    }
}
