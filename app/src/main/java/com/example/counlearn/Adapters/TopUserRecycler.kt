package com.example.counlearn.Adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.counlearn.R
import com.firebase.ui.auth.data.model.User
import com.google.firebase.auth.FirebaseUser

class TopUserRecycler(private val userList: ArrayList<com.example.counlearn.Modals.User>) :
    RecyclerView.Adapter<TopUserRecycler.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_toplist
            , parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = userList[position]

        holder.name.text = currentitem.name
        holder.scoor.text = currentitem.email

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.userName)
        val scoor : TextView = itemView.findViewById(R.id.userScore)
    }

}