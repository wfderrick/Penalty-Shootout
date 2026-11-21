package com.example.penaltyshootout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val itemList : List<ItemModel>) : RecyclerView.Adapter<MyAdapter.TileViewHolder>() {

    class TileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tile: TextView = view.findViewById(R.id.tileTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tile, parent, false)
        return TileViewHolder(view)
    }

    override fun onBindViewHolder(holder: TileViewHolder, position: Int) {
        val item = itemList[position]
        holder.tile.text = item.rank.toString() + "  " + item.username + "  " + item.score.toString()
    }

    override fun getItemCount(): Int = itemList.size

}