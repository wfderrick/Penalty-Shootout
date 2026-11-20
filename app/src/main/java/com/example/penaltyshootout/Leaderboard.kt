package com.example.penaltyshootout

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Leaderboard(
private val items: List<String>,
private val onTileClick: (String) -> Unit
) : RecyclerView.Adapter<Leaderboard.TileViewHolder>() {

    class TileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tileTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tile, parent, false)
        return TileViewHolder(view)
    }

    override fun onBindViewHolder(holder: TileViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item
        holder.itemView.setOnClickListener { onTileClick(item) }
    }

    override fun getItemCount(): Int = items.size



    fun getLeaderboard() : Array<Array<String>>{
        var firebase = FirebaseDatabase.getInstance()
        var ref = firebase.getReference("leaderboard")
        var test = ref.toString()
        Log.w("Leaderboard", test)

        var res = Array<Array<String>>(20, {Array<String>(3, {"0"})})
        return res
    }


}