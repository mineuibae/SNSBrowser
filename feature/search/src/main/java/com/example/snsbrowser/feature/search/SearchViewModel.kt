package com.example.snsbrowser.feature.search

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.snsbrowser.domain.GetYoutubeChannelListUseCase
import com.example.snsbrowser.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    getYoutubeChannelListUseCase: GetYoutubeChannelListUseCase
): BaseViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    fun modifyQuery(query: String) {
        _searchQuery.value = query
    }

    @ExperimentalCoroutinesApi
    val channels = searchQuery.filter { query ->
        query.isNotEmpty()
    }.flatMapLatest { query ->
        getYoutubeChannelListUseCase(query)
    }.cachedIn(viewModelScope)
}