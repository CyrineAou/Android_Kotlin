package com.example.cv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class CareerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
        val frameLayout= findViewById<FrameLayout>(R.id.experienceFrameLayout)
        supportFragmentManager.beginTransaction().replace(R.id.experienceFrameLayout,ExperienceFragment()).commit()
    }
}