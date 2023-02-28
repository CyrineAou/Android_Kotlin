package com.example.cv4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class ExpAdapter(val list: List<Experience>) : RecyclerView.Adapter<ExpAdapter.ViewHolder>() {
        inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            var image: ImageView = itemView.findViewById(R.id.companyImage)
            var name: TextView = itemView.findViewById(R.id.companyName)
            var address: TextView = itemView.findViewById(R.id.companyAddress)
            var startDay: TextView = itemView.findViewById(R.id.dateJob)
            var leavingDay: TextView = itemView.findViewById(R.id.dateLeavingJob)
            var description: TextView = itemView.findViewById(R.id.experienceDesc)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.experience_list, parent, false)

            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.text = list[position].companyName
            holder.address.text = list[position].companyAddress
            holder.description.text = list[position].description
            holder.startDay.text = list[position].dateStartJob
            holder.leavingDay.text = list[position].dateEndJob
            holder.image.setImageResource(list[position].companyImage)
        }
    }
}