package com.example.snsbrowser.testing.datasource

import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.domain.model.YoutubeChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestYoutubeRemoteDataSource : YoutubeRemoteDataSource {

    override fun search(query: String): Flow<List<YoutubeChannel>> = flow {
        emit(testYoutubeChannels)
    }
}

private val testYoutubeChannel1 = YoutubeChannel(
    channelId = "1",
    channelTitle = "test youtube channel 1",
    description = "test youtube channel 1",
    thumbnail = "https://test.youtube.channel/1"
)

private val testYoutubeChannel2 = YoutubeChannel(
    channelId = "2",
    channelTitle = "test youtube channel 2",
    description = "test youtube channel 2",
    thumbnail = "https://test.youtube.channel/2"
)

private val testYoutubeChannel3 = YoutubeChannel(
    channelId = "3",
    channelTitle = "test youtube channel 3",
    description = "test youtube channel 3",
    thumbnail = "https://test.youtube.channel/3"
)

private val testYoutubeChannels = listOf(testYoutubeChannel1, testYoutubeChannel2, testYoutubeChannel3)