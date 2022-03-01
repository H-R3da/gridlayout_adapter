package com.example.mediaplayer1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adaptor(private val context: Context, private val item : ArrayList<String>) : RecyclerView.Adapter <Adaptor.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val button  : Button = itemView.findViewById(R.id.button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.text = item[position]
        holder.button.setOnClickListener {
            Toast.makeText(context,item[position],Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}