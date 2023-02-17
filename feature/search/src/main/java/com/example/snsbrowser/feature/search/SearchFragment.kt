package com.example.snsbrowser.feature.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.snsbrowser.feature.search.databinding.FragmentSearchBinding
import com.example.snsbrowser.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
@OptIn(ExperimentalCoroutinesApi::class)
class SearchFragment : BaseFragment() {
    override val binding: FragmentSearchBinding by binding(R.layout.fragment_search)
    override val viewModel by viewModels<SearchViewModel>()

    private val adapter by lazy { SearchPagingDataAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerView.adapter = adapter
        }

        lifecycleScope.launchWhenStarted {
            viewModel.channels.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}