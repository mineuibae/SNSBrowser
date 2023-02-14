package com.example.snsbrowser.data.youtube.datasource.remote.retrofit

import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.data.youtube.datasource.remote.response.asModel
import com.example.snsbrowser.domain.model.YoutubeChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class YoutubeRetrofitDataSource @Inject constructor(
    private val youtubeApi: YoutubeApi
) : YoutubeRemoteDataSource {

    override fun search(query: String): Flow<List<YoutubeChannel>> = flow {
        val response = youtubeApi.search(
            part = "snippet",
            pageToken = null,
            q = query,
            maxResults = MAXIMUM_SEARCH_PAGE,
            type = "channel"
        )

        emit(response.items.map { it.asModel() })
    }

    companion object {
        private const val MAXIMUM_SEARCH_PAGE = 5
    }
}