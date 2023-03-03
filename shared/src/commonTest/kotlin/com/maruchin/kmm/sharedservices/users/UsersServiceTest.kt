package com.maruchin.kmm.sharedservices.users

import com.maruchin.kmm.sharedservices.libs.libsModule
import com.maruchin.kmm.sharedservices.mock.HttpMock
import com.maruchin.kmm.sharedservices.mock.mocksModule
import com.maruchin.kmm.sharedservices.sampleUsers
import com.maruchin.kmm.sharedservices.sampleUsersJson
import com.maruchin.kmm.sharedservices.session.sessionModule
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
class UsersServiceTest : KoinTest {

    private val httpMock: HttpMock by inject()
    private val usersService: UsersService by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(libsModule, sessionModule, usersModule, mocksModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `No logged user`() = runTest {
        val loggedUser = usersService.getLoggedUser()

        assertNull(loggedUser)
    }

    @Test
    fun `User logged in`() = runTest {
        httpMock.mockUserByEmail(sampleUsersJson[0])
        usersService.loginUser(sampleUsers[0].email)
        val loggedUser = usersService.getLoggedUser()

        assertEquals(sampleUsers[0], loggedUser)
    }

    @Test
    fun `User logged out`() = runTest {
        httpMock.mockUserByEmail(sampleUsersJson[0])
        usersService.loginUser(sampleUsers[0].email)
        usersService.logoutUser()
        val loggedUser = usersService.getLoggedUser()

        assertNull(loggedUser)
    }
}
