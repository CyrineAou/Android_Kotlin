package com.esprit.diceapp.views.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.room.Room
import com.esprit.diceapp.R
import com.esprit.diceapp.models.Experience
import com.esprit.diceapp.storage.AppDatabase
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.runBlocking

class AddExperience : AppCompatActivity() {
    private val PICK_FROM_GALERY = 100
    private var imageIsEmpty = true
    lateinit var imgData: Uri
    lateinit var image :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)
        val name = findViewById<TextInputEditText>(R.id.addCompanyNameText)
        val address = findViewById<TextInputEditText>(R.id.addCompanyAddressText)
        val startDate = findViewById<TextInputEditText>(R.id.addStartDateText)
        val endDate = findViewById<TextInputEditText>(R.id.addEndDateText)
        image = findViewById<ImageView>(R.id.addImageExperience)
        val btn = findViewById<Button>(R.id.addExpBtn)
        startDate.setOnClickListener {
            val dateP=MaterialDatePicker.Builder.datePicker().setTitleText("Select Your starting day at the company")
                .build()
            dateP.addOnPositiveButtonClickListener {
                it@startDate.setText(dateP.headerText)
            }
            dateP.show(supportFragmentManager,"OPENED")
        }
        endDate.setOnClickListener {
            val dateP=MaterialDatePicker.Builder.datePicker().setTitleText("Select Your starting day at the company")
                .build()
            dateP.addOnPositiveButtonClickListener {
                it@endDate.setText(dateP.headerText)
            }
            dateP.show(supportFragmentManager,"OPENED")
        }
        image.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, PICK_FROM_GALERY)
        }
        btn.setOnClickListener {
        var canPass=true
            val pair= listOf(name,address,startDate,endDate)
                .zip(listOf<TextInputLayout>(findViewById(R.id.addCompanyName)
                    ,findViewById(R.id.addCompanyAddress),findViewById(R.id.addStartDate),findViewById(R.id.addEndDate)))
            for ((editText,bg) in pair){
                if (editText.text!!.isEmpty()){
                    canPass = false
                    bg.error = "Must not be empty"
                }
            }
            if (imageIsEmpty) {
                Toast.makeText(this, "Please pick an image", Toast.LENGTH_SHORT).show()
                canPass = false
            }
            if(canPass){
                val db=Room.databaseBuilder(
                    this,
                    AppDatabase::class.java, "CV-database"
                ).build()
               runBlocking { db.experienceDao().insert(Experience(0,imgData,name.text.toString()
                   ,address.text.toString(),startDate.text.toString(),endDate.text.toString())) }
                finish()
            }
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