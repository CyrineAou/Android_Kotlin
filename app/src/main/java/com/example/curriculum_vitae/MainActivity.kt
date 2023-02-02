package com.example.curriculum_vitae

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext : Button = findViewById((R.id.next))
        val btnRest : Button = findViewById((R.id.rest))
        val name : EditText = findViewById(R.id.name)
        val age : EditText = findViewById(R.id.age)
        val email : EditText = findViewById(R.id.email)
        val android : SeekBar = findViewById(R.id.android)
        val ios : SeekBar = findViewById(R.id.ios)
        val flutter : SeekBar = findViewById(R.id.flutter)
        val genre : RadioGroup = findViewById(R.id.radioGroup)
        val femme :RadioButton = findViewById(R.id.femme)
        val homme :RadioButton = findViewById(R.id.homme)
        genre.check(homme.id)

        btnNext.setOnClickListener{
            if (TextUtils.isEmpty(name.text) || TextUtils.isEmpty(age.text) || TextUtils.isEmpty(email.text)) {
                val toast = Toast.makeText(this, "Remplissez les champs", Toast.LENGTH_SHORT)
                toast.show()
            } else if(!(Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())) {
                val toast = Toast.makeText(this, "Invalid email" , Toast.LENGTH_SHORT)
                toast.show()
            } else {
                if(android.getProgress()>80)
                {val toast = Toast.makeText(this, "Vous ete excellent en Android ", Toast.LENGTH_SHORT)
                    toast.show()}
              else  if(ios.getProgress()>80)
                {val toast = Toast.makeText(this, "Vous ete excellent en IOS ", Toast.LENGTH_SHORT)
                    toast.show()}
              else  if(flutter.getProgress()>80)
                {val toast = Toast.makeText(this, "Vous ete excellent en FLUTTER ", Toast.LENGTH_SHORT)
                    toast.show()}
              else if( (android.getProgress()<=30) || ios.getProgress()<=30 ||flutter.getProgress()<=30)
                {val toast = Toast.makeText(this, "Vous devez travaillez sur vos Skills ", Toast.LENGTH_SHORT)
                    toast.show()}
            else {val toast = Toast.makeText(this, "Vous avez de bon Skills ", Toast.LENGTH_SHORT)
                    toast.show()}
            }
        }
        btnRest.setOnClickListener{
            name.setText("")
            age.setText("")
            email.setText("")
            android.setProgress(0)
            ios.setProgress(0)
            flutter.setProgress(0)
            genre.clearCheck()

        }
    }
}