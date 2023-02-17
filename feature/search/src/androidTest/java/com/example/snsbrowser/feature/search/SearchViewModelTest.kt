package com.example.snsbrowser.feature.search

import androidx.paging.AsyncPagingDataDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListUpdateCallback
import com.example.snsbrowser.domain.GetYoutubeChannelListUseCase
import com.example.snsbrowser.domain.model.YoutubeChannel
import com.example.snsbrowser.testing.model.testYoutubeChannels
import com.example.snsbrowser.testing.rule.MainDispatcherRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import kotlin.test.assertEquals

@HiltAndroidTest
@OptIn(ExperimentalCoroutinesApi::class)
class SearchViewModelTest {
    private val testScope = TestScope()
    private val testDispatcher = StandardTestDispatcher(testScope.testScheduler)

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(testDispatcher)

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject lateinit var getYoutubeChannelListUseCase: GetYoutubeChannelListUseCase
    private lateinit var viewModel: SearchViewModel

    @Before
    fun init() {
        hiltRule.inject()
        viewModel = SearchViewModel(getYoutubeChannelListUseCase)
    }

    @Test
    fun test_search_viewmodel() = testScope.runTest {
        val differ = AsyncPagingDataDiffer(
            diffCallback = TestDiffCallback(),
            updateCallback = TestListCallback(),
            workerDispatcher = Dispatchers.Main
        )
        differ.submitData(viewModel.channels.first())

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