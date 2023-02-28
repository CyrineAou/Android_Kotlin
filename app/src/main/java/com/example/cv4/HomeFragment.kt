package com.example.cv4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HomeFragment(val name:String, val age:String,  val gender:String,val email:String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<TextView>(R.id.welcomingText).text = "Hello, My name is $name"
        view.findViewById<TextView>(R.id.welcomeInfoText).text = "I have $age years old" +
                "\nand i'm a $gender" +
                "\nYou can contact me via my email \n$email"
        return view
    }
}