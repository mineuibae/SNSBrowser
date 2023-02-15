package com.example.snsbrowser.data.youtube.datasource.remote.retrofit

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.snsbrowser.data.youtube.datasource.remote.response.asModel
import com.example.snsbrowser.domain.model.YoutubeChannel

class YoutubeChannelPagingSource(
    private val youtubeApi: YoutubeApi,
    private val query: String
) : PagingSource<YoutubeSearchKey, YoutubeChannel>() {

    override suspend fun load(params: LoadParams<YoutubeSearchKey>): LoadResult<YoutubeSearchKey, YoutubeChannel> {
        val key = params.key ?: YoutubeSearchKey(page = 1, pageToken = null)
        return try {
            val response = youtubeApi.search(
                part = "snippet",
                pageToken = key.pageToken,
                q = query,
                maxResults = params.loadSize,
                type = "channel"
            )

            val nextPageToken = response.nextPageToken
            val nextPage = key.page + 1

            LoadResult.Page(
                data = response.items.map { it.asModel() },
                prevKey = null,
                nextKey = if(nextPageToken == null || nextPage > MAXIMUM_SEARCH_PAGE) null else YoutubeSearchKey(nextPage, nextPageToken)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<YoutubeSearchKey, YoutubeChannel>): YoutubeSearchKey? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    companion object {
        private const val MAXIMUM_SEARCH_PAGE = 5
    }
}

data class YoutubeSearchKey(
    val page: Int,
    val pageToken: String?
)