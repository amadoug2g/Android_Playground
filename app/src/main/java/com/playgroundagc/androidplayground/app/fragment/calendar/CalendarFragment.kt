package com.playgroundagc.androidplayground.app.fragment.calendar

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.playgroundagc.androidplayground.R
import com.playgroundagc.androidplayground.databinding.FragmentCalendarBinding
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class CalendarFragment : Fragment(), CalendarClickListener {

    private lateinit var binding: FragmentCalendarBinding
    private lateinit var selectedDate: LocalDate

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        lateinit var calendarAdapter: CalendarAdapter
    }

    //region Override Methods
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false)

        selectedDate = LocalDate.now()
        setupViews()

        return binding.root
    }

    override fun onClick(position: Int, text: String) {
        if (text != "") {
            Toast.makeText(requireContext(), "Selected: $text ${monthYearFromDate(selectedDate)}", Toast.LENGTH_SHORT).show()
        }
    }
    //endregion

    //region Setup
    @RequiresApi(Build.VERSION_CODES.O)
    fun setupViews() {
        setupRecyclerView()

        binding.apply {
            monthNextBtn.setOnClickListener {
                nextMonthAction()
            }
            monthPrevBtn.setOnClickListener {
                previousMonthAction()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setupRecyclerView() {
        binding.monthTextView.text = monthYearFromDate(selectedDate)
        val daysInMonth = daysInMonthArray(selectedDate)

        calendarAdapter = CalendarAdapter(daysInMonth, this)
        val layoutManager: RecyclerView.LayoutManager =
            GridLayoutManager(context, 7)
        binding.calenderRecyclerView.layoutManager = layoutManager
        binding.calenderRecyclerView.adapter = calendarAdapter
    }
    //endregion

    //region Calendar
    @RequiresApi(Build.VERSION_CODES.O)
    fun daysInMonthArray(date: LocalDate): MutableList<String> {
        val result = mutableListOf<String>()

        val yearMonth = YearMonth.from(date)

        val daysInMonth = yearMonth.lengthOfMonth()

        val firstOfMonth = selectedDate.withDayOfMonth(1)
        val dayOfWeek = firstOfMonth.dayOfWeek.value

        for (i in 1..42) {
            if (i <= dayOfWeek || i > daysInMonth + dayOfWeek) {
                result.add("")
            } else {
                result.add(java.lang.String.valueOf(i - dayOfWeek))
            }
        }
        return result
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun monthYearFromDate(date: LocalDate): String? {
        val formatter = DateTimeFormatter.ofPattern("MMMM yyyy")
        return date.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun previousMonthAction() {
        selectedDate = selectedDate.minusMonths(1)
        setupRecyclerView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun nextMonthAction() {
        selectedDate = selectedDate.plusMonths(1)
        setupRecyclerView()
    }
    //endregion
}