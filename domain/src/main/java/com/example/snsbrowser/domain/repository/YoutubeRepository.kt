package com.example.snsbrowser.domain.repository

import androidx.paging.PagingData
import com.example.snsbrowser.domain.model.YoutubeChannel
import kotlinx.coroutines.flow.Flow

interface YoutubeRepository {
    fun searchChannels(query: String) : Flow<PagingData<YoutubeChannel>>
}