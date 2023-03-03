package com.maruchin.kmm.sharedservices.users.api

import com.maruchin.kmm.sharedservices.libs.libsModule
import com.maruchin.kmm.sharedservices.mock.HttpMock
import com.maruchin.kmm.sharedservices.mock.mocksModule
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
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class UsersApiTest : KoinTest {

    private val httpMock: HttpMock by inject()
    private val usersApi: UsersApi by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(libsModule, usersModule, mocksModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Fetch user`() = runTest {
        httpMock.mockUser(sampleUsersJson[1])
        val user = usersApi.fetchUser(sampleUsersJson[1].id)

        assertEquals(sampleUsersJson[1], user)
    }

    @Test
    fun `Fetch user by email`() = runTest {
        httpMock.mockUserByEmail(sampleUsersJson[2])
        val user = usersApi.fetchUserByEmail(sampleUsersJson[2].email)

        assertContentEquals(listOf(sampleUsersJson[2]), user)
    }
}
