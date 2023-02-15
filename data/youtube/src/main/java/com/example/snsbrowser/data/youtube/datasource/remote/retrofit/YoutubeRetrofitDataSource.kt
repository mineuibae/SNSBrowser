package com.example.snsbrowser.data.youtube.datasource.remote.retrofit

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.domain.model.YoutubeChannel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class YoutubeRetrofitDataSource @Inject constructor(
    private val youtubeApi: YoutubeApi
) : YoutubeRemoteDataSource {

    override fun search(query: String): Flow<PagingData<YoutubeChannel>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = SEARCH_PAGE_SIZE, initialLoadSize = SEARCH_PAGE_SIZE),
            pagingSourceFactory = { YoutubeChannelPagingSource(youtubeApi, query) }
        ).flow
    }

    companion object {
        private const val SEARCH_PAGE_SIZE = 5
    }
}