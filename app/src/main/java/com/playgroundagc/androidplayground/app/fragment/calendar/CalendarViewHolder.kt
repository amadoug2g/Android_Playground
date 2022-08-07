package com.playgroundagc.androidplayground.app.fragment.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playgroundagc.androidplayground.databinding.CalendarCellBinding

class CalendarViewHolder(private val binding: CalendarCellBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, month: String, action: CalendarClickListener) {
        with(binding) {
            this.cellDayText.text = month

            this.cellDayText.setOnClickListener { action.onClick(position, month) }
        }
    }

    companion object {
        fun from(parent: ViewGroup): CalendarViewHolder {
            val inflater =
                LayoutInflater.from(parent.context)
            val binding = CalendarCellBinding.inflate(inflater, parent, false)
            return CalendarViewHolder(binding)
        }
    }
}