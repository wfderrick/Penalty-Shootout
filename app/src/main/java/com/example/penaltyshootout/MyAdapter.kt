package com.example.penaltyshootout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val itemList : List<Array<String>>) : RecyclerView.Adapter<MyAdapter.TileViewHolder>() {

    class TileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rank : TextView = view.findViewById(R.id.rank)
        val username : TextView = view.findViewById(R.id.username)
        val score : TextView = view.findViewById(R.id.score)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tile, parent, false)
        return TileViewHolder(view)
    }

    override fun onBindViewHolder(holder: TileViewHolder, position: Int) {
        val item = itemList[position]
        holder.rank.text = (position + 1).toString()
        holder.username.text = item[1]
        holder.score.text = item[2]
    }

    override fun getItemCount(): Int = itemList.size

}