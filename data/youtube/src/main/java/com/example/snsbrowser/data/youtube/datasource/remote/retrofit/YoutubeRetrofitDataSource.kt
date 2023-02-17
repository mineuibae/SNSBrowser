package com.example.snsbrowser.data.youtube.datasource.remote.retrofit

import androidx.paging.*
import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.domain.model.YoutubeChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class YoutubeRetrofitDataSource @Inject constructor(
    private val youtubeApi: YoutubeApi
) : YoutubeRemoteDataSource {

    override fun search(query: String): Flow<PagingData<YoutubeChannel>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = true, pageSize = SEARCH_PAGE_SIZE, initialLoadSize = SEARCH_PAGE_SIZE),
            pagingSourceFactory = { YoutubeChannelPagingSource(youtubeApi, query) }
        ).flow.map { pagingData ->
            val channelIds = mutableSetOf<String>()
            pagingData.filter { channel ->
                if(channelIds.contains(channel.channelId)) {
                    false
                } else {
                    channelIds.add(channel.channelId)
                }
            }
        }
    }

    companion object {
        private const val SEARCH_PAGE_SIZE = 5
    }
}