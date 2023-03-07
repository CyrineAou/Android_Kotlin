package com.esprit.diceapp.storage

import android.content.Context
import androidx.room.Room

object AppDB {
    fun init(context:Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "CV-database"
        ).build()
    }

}