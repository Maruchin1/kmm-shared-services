package com.maruchin.kmm.sharedservices

import com.maruchin.kmm.sharedservices.posts.FakePostsApi
import com.maruchin.kmm.sharedservices.posts.PostsApi
import com.maruchin.kmm.sharedservices.users.FakeUsersApi
import com.maruchin.kmm.sharedservices.users.UsersApi
import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.Settings
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

internal val testModule = module {
    single { MapSettings() } bind Settings::class
    single { FakePostsApi() } binds arrayOf(FakePostsApi::class, PostsApi::class)
    single { FakeUsersApi() } binds arrayOf(FakeUsersApi::class, UsersApi::class)
}
