package com.gomaa.runningtracking.data

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run(
    var img: Bitmap? = null,
    var timeStamp: Long = 0L,
    var avgSpeedInKmH: Float = 0f,
    var distanceMeters: Int = 0,
    var TimeInMillis: Long = 0L,
    var caloriesBurned: Int = 0,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}