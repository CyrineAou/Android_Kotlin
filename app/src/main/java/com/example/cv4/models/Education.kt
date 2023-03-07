package com.esprit.diceapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "educations")
data class Education(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val schoolImage:Int,
    val schoolName:String,
    val schoolAddress:String,
    val startDate:String,
    val graduationDate:String,
    val description:String
)