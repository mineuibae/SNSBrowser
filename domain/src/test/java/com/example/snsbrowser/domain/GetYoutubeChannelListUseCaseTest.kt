package com.example.snsbrowser.domain

import androidx.paging.AsyncPagingDataDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListUpdateCallback
import com.example.snsbrowser.domain.model.YoutubeChannel
import com.example.snsbrowser.testing.model.testYoutubeChannels
import com.example.snsbrowser.testing.repository.TestYoutubeRepository
import com.example.snsbrowser.testing.rule.MainDispatcherRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GetYoutubeChannelListUseCaseTest {
    private val testScope = TestScope()
    private val testDispatcher = StandardTestDispatcher(testScope.testScheduler)

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(testDispatcher)

    private val youtubeRepository = TestYoutubeRepository()

    val useCase = GetYoutubeChannelListUseCase(youtubeRepository)

    @Test
    fun test_get_youtube_channels() = testScope.runTest {
        val useCase = useCase("토스")
        val differ = AsyncPagingDataDiffer(
            diffCallback = TestDiffCallback(),
            updateCallback = TestListCallback(),
            workerDispatcher = Dispatchers.Main
        )
        differ.submitData(useCase.first())

        advanceUntilIdle()
        assertEquals(testYoutubeChannels, differ.snapshot().items)
    }

    class TestListCallback : ListUpdateCallback {
        override fun onChanged(position: Int, count: Int, payload: Any?) {}
        override fun onMoved(fromPosition: Int, toPosition: Int) {}
        override fun onInserted(position: Int, count: Int) {}
        override fun onRemoved(position: Int, count: Int) {}
    }

    class TestDiffCallback : DiffUtil.ItemCallback<YoutubeChannel>() {
        override fun areItemsTheSame(oldItem: YoutubeChannel, newItem: YoutubeChannel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: YoutubeChannel, newItem: YoutubeChannel): Boolean {
            return oldItem.channelId == newItem.channelId
        }
    }
}