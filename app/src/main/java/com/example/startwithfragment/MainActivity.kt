package com.example.startwithfragment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.startwithfragment.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.util.Patterns.EMAIL_ADDRESS as emailPattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = intent.getStringExtra("name")!!
        val email = intent.getStringExtra("email")!!
        val age = intent.getStringExtra("age")!!
        val gender = intent.getStringExtra("gender")!!
        findViewById<ImageView>(R.id.avatar).setImageURI(Uri.parse(intent.getStringExtra("imageUri")))
        findViewById<TextView>(R.id.userName).text = name
        findViewById<TextView>(R.id.userEmail).text = email
        val fragment = findViewById<FrameLayout>(R.id.frameLayout)
        findViewById<Toolbar>(R.id.toolbar2).setOnMenuItemClickListener { item ->
            if (item?.itemId == R.id.info) {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout,WelcomeFragment(name
                    ,age
                    ,gender,email)).commit()
            }
            true
        }
    }}