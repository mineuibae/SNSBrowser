package com.example.snsbrowser.domain

import com.example.snsbrowser.domain.model.YoutubeChannel
import com.example.snsbrowser.testing.repository.TestYoutubeRepository
import com.example.snsbrowser.testing.rule.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertContains

@OptIn(ExperimentalCoroutinesApi::class)
class GetYoutubeChannelListUseCaseTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val youtubeRepository = TestYoutubeRepository()

    val useCase = GetYoutubeChannelListUseCase(youtubeRepository)

    @Test
    fun test_get_youtube_channels() = runTest {
        val useCase = useCase("test youtube channel")

        youtubeRepository.sendYoutubeChannels(testYoutubeChannels)

        assertContains(useCase.first(), testYoutubeChannel1)
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