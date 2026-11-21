package com.example.penaltyshootout

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.penaltyshootout.R.id
import com.example.penaltyshootout.R.id.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity(), View.OnClickListener, SharedPreferences {

    private lateinit var playButton : TextView
    private lateinit var leaderboard : Leaderboard
    private lateinit var leaderboardButton : TextView
    private lateinit var recyclerView : RecyclerView
    private lateinit var databaseRef : DatabaseReference
    private lateinit var pref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playButton = findViewById<TextView>(play_button)
        leaderboardButton = findViewById<TextView>(leaderboard_button)
        leaderboardButton.setOnClickListener(this)
        playButton.setOnClickListener(this)
        pref = this.getSharedPreferences(this.packageName + "_preferences", Context.MODE_PRIVATE )


        leaderboard = Leaderboard()
        var firebase = FirebaseDatabase.getInstance()
        databaseRef = firebase.getReference("leaderboard")
        databaseRef.addValueEventListener(leaderboard)

    }



    override fun onClick(v : View?){
        when (v?.id){
            play_button -> { startPlay() }
            leaderboard_button -> { openLeaderboard() }
        }
    }

    fun retrieveSavedLeaderBoard(){

    }


    fun startPlay(){
        var intent = Intent(this, Game::class.java)
        startActivity(intent)
    }

    fun openLeaderboard(){
        setContentView(R.layout.leaderboard)
        recyclerView = findViewById(id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(leaderboard.getLeaderboard())
        leaderboard.newScore("test", 0, databaseRef)


    }
}