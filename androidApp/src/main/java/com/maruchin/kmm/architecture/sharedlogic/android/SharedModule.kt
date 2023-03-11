package com.maruchin.kmm.architecture.sharedlogic.android

import android.content.Context
import com.maruchin.kmm.sharedservices.DemoConfig
import com.maruchin.kmm.sharedservices.DemoSdk
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedModule {

    @Singleton
    @Provides
    fun sharedLibrary(@ApplicationContext context: Context): DemoSdk {
        val config = DemoConfig(
            settingsName = "demo_settings",
            context = context
        )
        return DemoSdk(config)
    }

    @Provides
    fun sessionSe(library: DemoSdk) = library.sessionService

    @Provides
    fun postsService(library: DemoSdk) = library.postsService
}
