package com.esprit.diceapp.storage.dao

import androidx.room.Dao
import androidx.room.*
import com.esprit.diceapp.models.Education
import com.esprit.diceapp.models.Experience

@Dao
interface EducationDao {
    @Insert
    suspend fun insert(education: Education)

    @Update
    suspend fun update(education: Education)

    @Delete
    suspend fun delete(education: Education)

    @Query("SELECT * FROM educations")
    suspend fun getAllEducations(): List<Education>
}