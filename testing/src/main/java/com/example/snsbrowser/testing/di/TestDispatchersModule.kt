package com.example.snsbrowser.testing.di

import com.example.snsbrowser.common.di.Dispatcher
import com.example.snsbrowser.common.di.DispatcherType
import com.example.snsbrowser.common.di.DispatchersModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher

@Module
@OptIn(ExperimentalCoroutinesApi::class)
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DispatchersModule::class]
)
object TestDispatchersModule {
    @Provides
    @Dispatcher(DispatcherType.IO)
    fun providesIODispatcher(testDispatcher: TestDispatcher): CoroutineDispatcher = testDispatcher
}
