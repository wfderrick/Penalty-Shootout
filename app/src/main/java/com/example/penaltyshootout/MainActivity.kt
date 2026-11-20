package com.example.penaltyshootout

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var playButton : TextView
    private lateinit var leaderboardView : LeaderboardView
    private lateinit var leaderboardButton : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playButton = findViewById<TextView>(R.id.play_button)
        leaderboardButton = findViewById<TextView>(R.id.leaderboard_button)
        leaderboardView = LeaderboardView(this)
        leaderboardButton.setOnClickListener(this)
        playButton.setOnClickListener(this)
    }

    override fun onClick(v : View?){
        when (v?.id){
            R.id.play_button -> { startPlay() }
            R.id.leaderboard_button -> { openLeaderboard() }
        }
    }

    fun startPlay(){
        var intent = Intent(this, Game::class.java)
        startActivity(intent)
    }

    fun openLeaderboard(){
        setContentView(leaderboardView)
        leaderboardView.postInvalidate()
    }
}