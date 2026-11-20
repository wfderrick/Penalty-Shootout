package com.example.penaltyshootout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.widget.ScrollView
import android.widget.TextView

class LeaderboardView : View {

    private lateinit var paint : Paint
    private lateinit var leaderBoard : Array<Array<String>>
    private lateinit var scroll : ScrollView
    constructor(context : Context, leaderBoard : Array<Array<String>>) : super(context) {
        this.paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 3.0f
        paint.isAntiAlias = true

        this.leaderBoard = leaderBoard

        this.scroll = ScrollView(context)
    }

    override fun onDraw(canvas : Canvas){
        super.onDraw(canvas)
        for(i in leaderBoard){
            var temp = TextView(context)
            temp.text = i[0] + "   " + i[1] + "   " + i[2]
            scroll.addView(temp)
        }
        scroll.draw(canvas)
    }
}