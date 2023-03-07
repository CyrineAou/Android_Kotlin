package com.esprit.diceapp.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esprit.diceapp.models.Education
import com.esprit.diceapp.models.Experience
import com.esprit.diceapp.storage.dao.EducationDao
import com.esprit.diceapp.storage.dao.ExperienceDao

@Database(entities = [Experience::class,Education::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun experienceDao(): ExperienceDao
    abstract fun educationDao(): EducationDao
}