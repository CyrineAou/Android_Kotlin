package com.example.cv4

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddExperience : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_experience)

        suspend fun addExperience() {
            val  companyname = titleEditText.text.toString().trim()
            val companyAdd = companyEditText.text.toString().trim()
            val startDate = startDateEditText.text.toString().trim()
            val endDate = endDateEditText.text.toString().trim()


            if (companyname.isEmpty() || companyAdd.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return
            }

            val experience = Experience(companyname, companyAdd, startDate, endDate)
            AppDatabase.getInstance(this).experienceDao().insert(experience)

            setResult(Activity.RESULT_OK)
            finish()
        }
        addButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                addExperience()
            }
        }


    }
}