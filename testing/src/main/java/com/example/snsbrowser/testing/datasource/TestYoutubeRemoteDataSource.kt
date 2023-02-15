package com.example.snsbrowser.testing.datasource

import androidx.paging.PagingData
import com.example.snsbrowser.data.youtube.datasource.remote.YoutubeRemoteDataSource
import com.example.snsbrowser.data.youtube.datasource.remote.response.asModel
import com.example.snsbrowser.domain.model.YoutubeChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestYoutubeRemoteDataSource : YoutubeRemoteDataSource {

    private val testYoutubeApi = TestYoutubeApi()

    override fun search(query: String): Flow<PagingData<YoutubeChannel>> = flow {
        val response = testYoutubeApi.search(
            part = "snippet",
            pageToken = null,
            q = query,
            type = "channel",
            maxResults = 5
        )

        emit(PagingData.from(response.items.map { it.asModel() }))
    }
}