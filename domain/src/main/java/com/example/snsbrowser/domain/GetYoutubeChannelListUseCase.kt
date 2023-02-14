package com.example.snsbrowser.domain

import com.example.snsbrowser.domain.repository.YoutubeRepository
import com.example.snsbrowser.domain.model.YoutubeChannel
import com.example.snsbrowser.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetYoutubeChannelListUseCase @Inject constructor(
    private val youtubeRepository: YoutubeRepository
) : BaseUseCase<String, Flow<List<YoutubeChannel>>>() {

    override fun execute(parameter: String): Flow<List<YoutubeChannel>> {
        return youtubeRepository.searchChannels(parameter)
    }
}