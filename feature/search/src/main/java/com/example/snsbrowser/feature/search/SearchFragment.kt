package com.example.snsbrowser.feature.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
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

            editText.apply {
                setOnEditorActionListener { _, actionId, _ ->
                    if (actionId == EditorInfo.IME_ACTION_GO) {
                        modifySearchListFromInput()
                        true
                    } else {
                        false
                    }
                }

                setOnKeyListener { _, keyCode, event ->
                    if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                        modifySearchListFromInput()
                        true
                    } else {
                        false
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.channels.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun FragmentSearchBinding.modifySearchListFromInput() {
        editText.text.let {
            if(it.isNotEmpty()) {
                smoothScrollToPosition()
                viewModel.modifyQuery(it.toString())
            }
        }
    }

    private fun FragmentSearchBinding.smoothScrollToPosition() {
        recyclerView.smoothScrollToPosition(0)
    }
}