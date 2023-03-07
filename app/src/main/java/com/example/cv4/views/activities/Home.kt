package com.esprit.diceapp.views.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.esprit.diceapp.R
import com.esprit.diceapp.views.fragments.WelcomeFragment

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val name = intent.getStringExtra("name")!!
        val email = intent.getStringExtra("email")!!
        val age = intent.getStringExtra("age")!!
        val gender = intent.getStringExtra("gender")!!
        findViewById<ImageView>(R.id.avatar).setImageURI(Uri.parse(intent.getStringExtra("imageUri")))
        findViewById<TextView>(R.id.userName).text = name
        findViewById<TextView>(R.id.userEmail).text = email
        val fragment = findViewById<FrameLayout>(R.id.frameLayout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        toolbar.setOnMenuItemClickListener { item ->
            if (item?.itemId == R.id.info) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frameLayout, WelcomeFragment(name
                    ,age
                    ,gender,email)
                ).commit()
            }
            true
        }
        findViewById<Button>(R.id.careerBtn).setOnClickListener {
            startActivity(Intent(this,Career::class.java))
        }
    }
}