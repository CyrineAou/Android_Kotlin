package com.esprit.diceapp.views.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.esprit.diceapp.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {
    lateinit var fullName: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var age: TextInputEditText
    private val PICK_FROM_GALERY = 100
    private var imageIsEmpty = true
    lateinit var imgData: Uri
    lateinit var image: ImageView
    var gender: String = "Male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        fullName = findViewById(R.id.fullNameText)
        email = findViewById(R.id.emailText)
        age = findViewById(R.id.ageText)
        image = findViewById(R.id.imageLogin)
        image.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, PICK_FROM_GALERY)
        }
        findViewById<RadioGroup>(R.id.genderRG).setOnCheckedChangeListener { group, checkedId ->
            gender = when (checkedId) {
                R.id.menRB -> "Male"
                R.id.womenRB -> "Female"
                else -> "Error"
            }
        }
        findViewById<Button>(R.id.toNext).setOnClickListener {
            toNext()
        }
    }
    private fun toNext() {
        var response = true
        val widgets = listOf(fullName, email, age)
        val backgrounds = listOf<TextInputLayout>(
            findViewById(R.id.textInputLayout1),
            findViewById(R.id.textInputLayout2),
            findViewById(R.id.textInputLayout3)
        )
        for ((widget, background) in widgets.zip(backgrounds)) {
            if (widget.text!!.isEmpty()) {
                background.error = "Must not be empty"
                response = false
            }
            else if ((widget == email) && (!widget.text!!.matches(Patterns.EMAIL_ADDRESS.toRegex()))) {
                background.error = "Must Be an email"
                response = false
            }
            else
                background.error = null
        }
        if(imageIsEmpty)
            Toast.makeText(this,"Please pick an image",Toast.LENGTH_SHORT).show()
        if (response&&!imageIsEmpty) {
            Log.e("Pass", "Passed congrats!!")
            val intent = Intent(this, Home::class.java)
            intent.putExtra("name", fullName.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("age", age.text.toString())
            intent.putExtra("gender", gender)
            intent.putExtra("imageUri", imgData.toString())
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK){
            if(requestCode==PICK_FROM_GALERY){
                imgData=data?.data!!
                imageIsEmpty = false
                image.setImageURI(imgData)
            }
        }
    }
}