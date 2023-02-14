package com.example.snsbrowser.data.youtube.repository

import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.domain.repository.YoutubeRepository
import com.example.snsbrowser.domain.model.YoutubeChannel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CacheYoutubeRepository @Inject constructor(
    private val youtubeRemoteDataSource: YoutubeRemoteDataSource
) : YoutubeRepository {

    override fun searchChannels(query: String): Flow<List<YoutubeChannel>> {
        return youtubeRemoteDataSource.search(query)
    }
}