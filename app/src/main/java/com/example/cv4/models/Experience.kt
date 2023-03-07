package com.esprit.diceapp.models

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "experiences")
data class Experience(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val companyImage:Uri,
    val companyName:String,
    val companyAddress:String,
    val dateStartJob:String,
    val dateEndJob:String,
    )
