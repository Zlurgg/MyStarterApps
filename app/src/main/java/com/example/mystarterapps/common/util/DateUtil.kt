package com.example.mystarterapps.common.util

import java.util.Calendar
class DateUtil {
    private val c: Calendar = Calendar.getInstance()
    fun getCurrentDate(): String {
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_MONTH)
        return "$year-$month-$day"
    }
}