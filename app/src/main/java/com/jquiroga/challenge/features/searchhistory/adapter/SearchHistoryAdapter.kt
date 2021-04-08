package com.jquiroga.challenge.features.searchhistory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jquiroga.challenge.databinding.ItemSearchHistoryBinding

class SearchHistoryAdapter : RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder>() {

    private val searchHistoryList = mutableListOf<String>()

    private var searchHistoryAdapterListener: SearchHistoryAdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemSearchHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(searchHistoryList[position])
    }

    override fun getItemCount(): Int = searchHistoryList.size

    fun addSearchHistory(values: List<String>) {
        searchHistoryList.addAll(values)
        notifyDataSetChanged()
    }

    fun setListeners(listener: SearchHistoryAdapterListener) {
        searchHistoryAdapterListener = listener
    }

    inner class ViewHolder(private val binding: ItemSearchHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(searchTerm: String) {
            binding.textSearchTerm.text = searchTerm
            binding.root.setOnClickListener {
                searchHistoryAdapterListener?.onClickSearch(searchTerm)
            }
        }
    }
}