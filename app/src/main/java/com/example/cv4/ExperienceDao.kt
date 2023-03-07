package com.example.cv4

import androidx.room.*

@Dao
interface ExperienceDao {
    @Insert
    suspend fun insert(experience: Experience)

    @Update
    suspend fun update(experience: Experience)

    @Delete
    suspend fun delete(experience: Experience)

    @Query("SELECT * FROM experience_table ORDER BY id DESC")
    suspend fun getAllExperiences(): List<Experience>
}