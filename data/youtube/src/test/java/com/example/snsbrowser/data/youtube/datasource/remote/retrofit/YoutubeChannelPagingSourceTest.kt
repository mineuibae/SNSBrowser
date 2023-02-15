package com.example.snsbrowser.data.youtube.datasource.remote.retrofit

import androidx.paging.PagingSource
import com.example.snsbrowser.testing.datasource.TestYoutubeApi
import com.example.snsbrowser.testing.model.testYoutubeChannels
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class YoutubeChannelPagingSourceTest {

    private val testYoutubeApi = TestYoutubeApi()

    @Test
    fun itemKeyedSubredditPagingSource() = runTest {
        val pagingSource = YoutubeChannelPagingSource(testYoutubeApi, "토스")
        assertEquals(
            expected = PagingSource.LoadResult.Page(
                data = testYoutubeChannels,
                prevKey = null,
                nextKey = YoutubeSearchKey(2, "CAUQAA")
            ),
            actual = pagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            ),
        )
    }
}