package com.example.cv4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "experience_table")
data class Experience(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val companyname: String,
    val companyAdd: String,
    val startDate: String,
    val endDate: String,

)
