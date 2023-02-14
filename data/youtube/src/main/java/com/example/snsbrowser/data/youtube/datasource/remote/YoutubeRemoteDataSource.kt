package com.example.snsbrowser.data.youtube.datasource.remote

import com.example.snsbrowser.domain.model.YoutubeChannel
import kotlinx.coroutines.flow.Flow

interface YoutubeRemoteDataSource {
    fun search(query: String): Flow<List<YoutubeChannel>>
}