package com.example.snsbrowser.testing.repository

import androidx.paging.PagingData
import com.example.snsbrowser.domain.model.YoutubeChannel
import com.example.snsbrowser.domain.repository.YoutubeRepository
import com.example.snsbrowser.testing.datasource.TestYoutubeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestYoutubeRepository @Inject constructor(): YoutubeRepository {

    private val youtubeRemoteDataSource = TestYoutubeRemoteDataSource()

    override fun searchChannels(query: String): Flow<PagingData<YoutubeChannel>> = youtubeRemoteDataSource.search(query)
}