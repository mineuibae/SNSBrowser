package com.example.snsbrowser.domain

import androidx.paging.PagingData
import com.example.snsbrowser.domain.repository.YoutubeRepository
import com.example.snsbrowser.domain.model.YoutubeChannel
import com.example.snsbrowser.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetYoutubeChannelListUseCase @Inject constructor(
    private val youtubeRepository: YoutubeRepository
) : BaseUseCase<String, Flow<PagingData<YoutubeChannel>>>() {

    override fun execute(parameter: String): Flow<PagingData<YoutubeChannel>> {
        return youtubeRepository.searchChannels(parameter)
    }
}