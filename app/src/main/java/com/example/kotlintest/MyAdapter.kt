package com.example.kotlintest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val myList:List<Model>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.model_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = myList[position]
        holder.firstTextView.text=model.firstName
        holder.lastTextView.text=model.lastName
    }

    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val firstTextView: TextView = itemView.findViewById(R.id.first_name_txv)
        val lastTextView: TextView = itemView.findViewById(R.id.last_name_txv)
    }

}