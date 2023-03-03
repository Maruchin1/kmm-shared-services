package com.maruchin.kmm.sharedservices.mock

import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.Settings
import io.ktor.client.engine.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val mocksModule = module {
    singleOf(::HttpMock) bind HttpClientEngineFactory::class
    single { MapSettings() } bind Settings::class
}
