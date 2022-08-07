package com.playgroundagc.androidplayground.app.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.playgroundagc.androidplayground.R
import com.playgroundagc.androidplayground.databinding.SimpleLayoutBinding

/**
 * Created by Amadou on 05/08/2022, 19:13
 *
 * Purpose:
 *
 */

class ListingAdapter : ListAdapter<String, ListViewHolder>(ListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

}

class ListViewHolder(private val binding: SimpleLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(text: String) {
        binding.textView.text = text
    }

    companion object {
        fun from(parent: ViewGroup): ListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.simple_layout, parent, false)
            val layout = SimpleLayoutBinding.bind(view)
            return ListViewHolder(layout)
        }
    }
}

class ListDiffUtil: DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}