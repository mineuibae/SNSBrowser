package com.example.snsbrowser.feature.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.snsbrowser.domain.model.YoutubeChannel
import com.example.snsbrowser.feature.search.databinding.ItemYoutubeSearchBinding

class SearchPagingDataAdapter : PagingDataAdapter<YoutubeChannel, SearchPagingDataAdapter.SearchViewHolder>(SearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ItemYoutubeSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val currentItem = getItem(position)?: return

        holder.binding.thumbnail.load(currentItem.thumbnail) {
            crossfade(true)
            placeholder(R.drawable.placeholder)
            transformations(CircleCropTransformation())
        }
        holder.binding.title.text = currentItem.channelTitle
    }

    class SearchViewHolder(val binding: ItemYoutubeSearchBinding) : RecyclerView.ViewHolder(binding.root)
}

class SearchDiffCallback : DiffUtil.ItemCallback<YoutubeChannel>() {
    override fun areItemsTheSame(oldItem: YoutubeChannel, newItem: YoutubeChannel): Boolean {
        return oldItem.channelId == newItem.channelId
    }

    override fun areContentsTheSame(oldItem: YoutubeChannel, newItem: YoutubeChannel): Boolean {
        return oldItem == newItem
    }
}