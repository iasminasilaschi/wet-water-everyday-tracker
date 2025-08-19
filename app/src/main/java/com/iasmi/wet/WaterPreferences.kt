package com.iasmi.wet

import android.content.Context
import android.content.SharedPreferences
import java.text.SimpleDateFormat
import java.util.*
import androidx.core.content.edit

class WaterPreferences(context: Context) {
    // Repository Pattern: Handles all data storage logic
    private val prefs: SharedPreferences = context.getSharedPreferences("water_tracker", Context.MODE_PRIVATE)
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    fun getTodaysWaterCount(): Int {
        val today = dateFormat.format(Date())
        val savedDate = prefs.getString("last_date", "")

        return if (savedDate == today) {
            // Same day - return saved count
            prefs.getInt("water_count", 0)
        } else {
            // New day - reset to 0
            0
        }
    }

    fun saveWaterCount(count: Int) {
        val today = dateFormat.format(Date())
        prefs.edit {
            putInt("water_count", count)
                .putString("last_date", today)
        }
    }
}