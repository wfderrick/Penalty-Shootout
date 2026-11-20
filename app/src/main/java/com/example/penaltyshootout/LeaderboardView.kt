package com.example.penaltyshootout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeaderboardView  {
    private lateinit var paint : Paint
    private lateinit var leaderboard : Array<Array<String>>
    private lateinit var leaderboardClass : Leaderboard
    private lateinit var leaderboardContainer : RecyclerView


    override fun onDraw(canvas : Canvas){
        super.onDraw(canvas)

        canvas.drawCircle(500f, 500f, 30f, paint)
    }

    companion object {
        const val DELTA_TIME : Long = 100L

    }
}