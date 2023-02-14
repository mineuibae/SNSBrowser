package com.example.snsbrowser.data.youtube.di

import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.data.youtube.datasource.remote.retrofit.YoutubeRetrofitDataSource
import com.example.snsbrowser.data.youtube.repository.CacheYoutubeRepository
import com.example.snsbrowser.domain.repository.YoutubeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsYoutubeRepository(
        youtubeRepository: CacheYoutubeRepository
    ): YoutubeRepository

    @Binds
    fun YoutubeRetrofitDataSource.binds(): YoutubeRemoteDataSource
}