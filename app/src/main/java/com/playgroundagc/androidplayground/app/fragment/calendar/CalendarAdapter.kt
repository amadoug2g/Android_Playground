package com.playgroundagc.androidplayground.app.fragment.calendar

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Amadou on 07/08/2022, 19:05
 *
 * Purpose:
 *
 */

class CalendarAdapter(
    private var daysOfMonth: MutableList<String>,
    private var action: CalendarClickListener
) : RecyclerView.Adapter<CalendarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val currentItem = daysOfMonth[position]
        holder.bind(position, currentItem, action)
    }

    override fun getItemCount(): Int = daysOfMonth.size
}

