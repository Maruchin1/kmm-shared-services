package com.maruchin.kmm.sharedservices.core

import com.russhwolf.settings.MapSettings
import com.russhwolf.settings.Settings
import io.ktor.client.engine.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.bind
import org.koin.dsl.module

val fakeCoreDependenciesModule = module {
    single { FakeHttpEngine() } bind HttpClientEngineFactory::class

    single { MapSettings() } bind Settings::class

    factory { Dispatchers.Unconfined }

    single { CoroutineScope(SupervisorJob() + Dispatchers.Unconfined) }
}
