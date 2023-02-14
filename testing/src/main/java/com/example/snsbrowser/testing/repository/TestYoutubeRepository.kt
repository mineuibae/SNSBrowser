package com.example.snsbrowser.testing.repository

import com.example.snsbrowser.domain.model.YoutubeChannel
import com.example.snsbrowser.domain.repository.YoutubeRepository
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class TestYoutubeRepository : YoutubeRepository {
    private val channelFlow: MutableSharedFlow<List<YoutubeChannel>> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    override fun searchChannels(query: String): Flow<List<YoutubeChannel>> = channelFlow

    fun sendYoutubeChannels(channels: List<YoutubeChannel>) {
        channelFlow.tryEmit(channels)
    }
}