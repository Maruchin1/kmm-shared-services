package com.maruchin.kmm.sharedservices.mock

import com.maruchin.kmm.sharedservices.posts.api.PostJson
import com.maruchin.kmm.sharedservices.users.api.UserJson
import io.ktor.client.engine.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private typealias HttpHandler = MockRequestHandleScope.(HttpRequestData) -> HttpResponseData?

internal class HttpMock : HttpClientEngineFactory<MockEngineConfig> {

    private val httpHandlers = mutableListOf<HttpHandler>()

    override fun create(block: MockEngineConfig.() -> Unit): HttpClientEngine {
        return MockEngine { request ->
            httpHandlers.reversed().firstNotNullOf { handler ->
                handler(request)
            }
        }
    }

    fun mockAllPosts(posts: List<PostJson>) = handle { request ->
        request
            .takeIf {
                it.url == Url("https://jsonplaceholder.typicode.com/posts")
            }
            ?.let {
                respond(
                    content = ByteReadChannel(Json.encodeToString(posts)),
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            }
    }

    fun mockUser(user: UserJson) = handle { request ->
        request
            .takeIf {
                it.url == Url("https://jsonplaceholder.typicode.com/users/${user.id}")
            }
            ?.let {
                respond(
                    content = ByteReadChannel(Json.encodeToString(user)),
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            }
    }

    fun mockUserByEmail(user: UserJson) = handle { request ->
        request
            .takeIf {
                it.url == Url("https://jsonplaceholder.typicode.com/users?email=${user.email}")
            }
            ?.let {
                respond(
                    content = ByteReadChannel(Json.encodeToString(listOf(user))),
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json"),
                )
            }
    }

    private fun handle(handler: HttpHandler) {
        httpHandlers += handler
    }
}
