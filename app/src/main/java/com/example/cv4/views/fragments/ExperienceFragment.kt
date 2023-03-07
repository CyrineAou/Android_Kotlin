package com.esprit.diceapp.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.esprit.diceapp.R
import com.esprit.diceapp.adapters.ExperiencesAdapter
import com.esprit.diceapp.models.Experience
import com.esprit.diceapp.storage.AppDB
import com.esprit.diceapp.storage.AppDatabase
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class ExperienceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_experience, container, false)
        val db= Room.databaseBuilder(
            view.context,
            AppDatabase::class.java, "CV-database"
        ).build()
       val list=runBlocking { db.experienceDao().getAllExperiences() }
       Log.e("list","$list")
        view.findViewById<RecyclerView>(R.id.experienceList).adapter = ExperiencesAdapter(listOf())
        return view
    }
}