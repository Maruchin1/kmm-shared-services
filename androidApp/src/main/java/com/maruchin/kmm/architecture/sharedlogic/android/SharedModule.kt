package com.maruchin.kmm.architecture.sharedlogic.android

import android.content.Context
import com.maruchin.kmm.architecture.sharedlogic.SharedConfig
import com.maruchin.kmm.architecture.sharedlogic.SharedLibrary
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
    fun sharedLibrary(@ApplicationContext context: Context): SharedLibrary {
        val config = SharedConfig(
            settingsName = "demo_settings",
            context = context
        )
        return SharedLibrary(config)
    }

    @Provides
    fun usersService(library: SharedLibrary) = library.usersService

    @Provides
    fun postsService(library: SharedLibrary) = library.postsService
}
