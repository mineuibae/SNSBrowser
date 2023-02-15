package com.example.snsbrowser.testing.di

import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.data.youtube.di.DataModule
import com.example.snsbrowser.domain.repository.YoutubeRepository
import com.example.snsbrowser.testing.datasource.TestYoutubeRemoteDataSource
import com.example.snsbrowser.testing.repository.TestYoutubeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
interface TestDataModule {

    @Binds
    fun bindsYoutubeRepository(
        testYoutubeRepository: TestYoutubeRepository
    ): YoutubeRepository

    @Binds
    fun TestYoutubeRemoteDataSource.binds(): YoutubeRemoteDataSource
}