package com.example.cv4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ExperienceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_experience, container, false)
        view.findViewById<RecyclerView>(R.id.experienceList).adapter = ExpAdapter(experiencesInit())
        return view
    }
    fun experiencesInit():List<Experience>{
        return listOf(
            Experience(R.drawable.ic_logo_amazon,"Amazon"
                ,"USA","10/11/2019","Today","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a nulla quis leo egestas fringilla sed sed massa. Sed felis purus, fringilla eget ultricies sit amet, efficitur non erat. Proin nec eros purus. Ut leo tortor, semper a nisl non, sagittis vulputate ipsum. Vestibulum ut nunc est. Donec sed mi non purus fringilla cursus nec eu sapien. Integer eget diam porttitor, ullamcorper lorem ullamcorper, pulvinar neque. Pellentesque maximus nisi in aliquam faucibus. Pellentesque semper bibendum mi ut pretium. Mauris lobortis sapien ac velit luctus, non dapibus odio porta."),
            Experience(R.drawable.ic_logo_facebook,"Facebook","France"
                ,"24/06/2012","24/06/2013","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a nulla quis leo egestas fringilla sed sed massa. Sed felis purus, fringilla eget ultricies sit amet, efficitur non erat. Proin nec eros purus. Ut leo tortor, semper a nisl non, sagittis vulputate ipsum. Vestibulum ut nunc est. Donec sed mi non purus fringilla cursus nec eu sapien. Integer eget diam porttitor, ullamcorper lorem ullamcorper, pulvinar neque. Pellentesque maximus nisi in aliquam faucibus. Pellentesque semper bibendum mi ut pretium. Mauris lobortis sapien ac velit luctus, non dapibus odio porta. Duis ullamcorper augue eu varius pretium. Donec efficitur sit amet lectus eu sollicitudin. Donec et rhoncus quam. Etiam feugiat eros vitae finibus posuere."),
            Experience(R.drawable.ic_logo_microsoft,"Microsoft","UK",
                "24/06/2014","24/06/2015","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a nulla quis leo egestas fringilla sed sed massa. Sed felis purus, fringilla eget ultricies sit amet, efficitur non erat. Proin nec eros purus."),
            Experience(R.drawable.ic_logo_esprit,"Esprit","Tunis","24/06/2010","24/06/2011",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a nulla quis leo egestas fringilla sed sed massa. Sed felis purus, fringilla eget ultricies sit amet, efficitur non erat. Proin nec eros purus. Ut leo tortor, semper a nisl non, sagittis vulputate ipsum. Vestibulum ut nunc est. Donec sed mi non purus fringilla cursus nec eu sapien. Integer eget diam porttitor, ullamcorper lorem ullamcorper, pulvinar neque. Pellentesque maximus nisi in aliquam faucibus. Pellentesque semper bibendum mi ut pretium. Mauris lobortis sapien ac velit luctus, non dapibus odio porta. Duis ullamcorper augue eu varius pretium.")
        )
    }}