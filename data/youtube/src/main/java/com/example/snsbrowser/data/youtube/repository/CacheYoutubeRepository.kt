package com.example.snsbrowser.data.youtube.repository

import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.domain.repository.YoutubeRepository
import javax.inject.Inject

class CacheYoutubeRepository @Inject constructor(
    private val youtubeRemoteDataSource: YoutubeRemoteDataSource
) : YoutubeRepository {

    override fun searchChannels(query: String) = youtubeRemoteDataSource.search(query)
}