package com.playgroundagc.androidplayground.app.fragment.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playgroundagc.androidplayground.databinding.CalendarCellBinding

/**
 * Created by Amadou on 07/08/2022, 19:05
 *
 * Purpose:
 *
 */

class CalendarAdapter : RecyclerView.Adapter<CalendarViewHolder>() {
    private var daysOfMonth = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val currentItem = daysOfMonth[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = daysOfMonth.size
}

class CalendarViewHolder(private val binding: CalendarCellBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(month: String) {
        with(binding) {
            this.cellDayText.text = month
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