package com.esprit.diceapp.adapters

import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esprit.diceapp.R
import com.esprit.diceapp.models.Experience


class ExperiencesAdapter(val list: List<Experience>): RecyclerView.Adapter<ExperiencesAdapter.ViewHolder>() {
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        var image:ImageView = itemView.findViewById(R.id.companyImage)
        var name:TextView = itemView.findViewById(R.id.companyName)
        var address:TextView = itemView.findViewById(R.id.companyAddress)
        var startDay:TextView = itemView.findViewById(R.id.dateJob)
        var leavingDay:TextView = itemView.findViewById(R.id.dateLeavingJob)
        var icon:ImageView=itemView.findViewById(R.id.deleteExpIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.experience_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].companyName
        holder.address.text = list[position].companyAddress
        holder.startDay.text = list[position].dateStartJob
        holder.leavingDay.text = list[position].dateEndJob
        holder.image.setImageURI(list[position].companyImage)
        holder.itemView.context
        holder.icon.setOnClickListener { AlertDialog.Builder(holder.itemView.context)
            .setMessage("Are you sure of deleting ${list[position].companyName} from your resume")
            .setTitle("Delete Experience")
            .setPositiveButton("Yes") { dialog, which -> Log.e("test","$dialog , which ==> $which") }
            .setNegativeButton("No"){ _,_ -> Log.e("test","Canceled")}
            .create().show()
        }
    }
}