package com.esprit.diceapp.storage.dao

import androidx.room.Dao
import androidx.room.*
import com.esprit.diceapp.models.Experience

@Dao
interface ExperienceDao {
    @Insert
    suspend fun insert(experience: Experience)

    @Update
    suspend fun update(experience: Experience)

    @Delete
    suspend fun delete(experience: Experience)

    @Query("SELECT * FROM experiences")
    suspend fun getAllExperiences(): List<Experience>
}