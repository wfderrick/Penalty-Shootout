package com.example.penaltyshootout

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.penaltyshootout.R.id
import com.example.penaltyshootout.R.id.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var playButton : TextView
    private lateinit var leaderboardView : LeaderboardView
    private lateinit var leaderboardButton : TextView
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playButton = findViewById<TextView>(play_button)
        leaderboardButton = findViewById<TextView>(leaderboard_button)
        leaderboardButton.setOnClickListener(this)
        playButton.setOnClickListener(this)
    }

    override fun onClick(v : View?){
        when (v?.id){
            play_button -> { startPlay() }
            leaderboard_button -> { openLeaderboard() }
        }
    }

    fun startPlay(){
        var intent = Intent(this, Game::class.java)
        startActivity(intent)
    }

    fun openLeaderboard(){
        setContentView(R.layout.leaderboard)
        recyclerView = findViewById(id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(leaderboard.get)
    }
}