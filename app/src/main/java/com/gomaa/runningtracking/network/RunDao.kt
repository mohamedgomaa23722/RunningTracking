package com.gomaa.runningtracking.network

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gomaa.runningtracking.data.Run

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("Select * from running_table order by timeStamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("Select * from running_table order by TimeInMillis DESC")
    fun getAllRunsSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("Select * from running_table order by caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("Select * from running_table order by avgSpeedInKmH DESC")
    fun getAllRunsSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("Select * from running_table order by distanceMeters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    @Query("Select SUM(timeInMillis) from running_table")
    fun getTotalTimeInMillis():LiveData<Long>

    @Query("Select SUM(caloriesBurned) from running_table")
    fun getTotalCaloriesBurned():LiveData<Int>

    @Query("Select SUM(distanceMeters) from running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("Select AVG(avgSpeedInKmH) from running_table")
    fun getTotalAvgSpeed(): LiveData<Float>
}