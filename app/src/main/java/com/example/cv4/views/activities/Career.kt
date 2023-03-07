package com.esprit.diceapp.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import com.esprit.diceapp.R
import com.esprit.diceapp.views.fragments.ExperienceFragment
import com.esprit.diceapp.views.fragments.WelcomeFragment

class Career : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
        val frameLayout= findViewById<FrameLayout>(R.id.experienceFrameLayout)
        supportFragmentManager.beginTransaction().replace(R.id.experienceFrameLayout,ExperienceFragment()).commit()
        findViewById<Toolbar>(R.id.toolbarExp).setOnMenuItemClickListener{item ->
            if (item?.itemId == R.id.AddExp) {
                startActivity(Intent(this,AddExperience::class.java))
            }
            true
        }
    }
}