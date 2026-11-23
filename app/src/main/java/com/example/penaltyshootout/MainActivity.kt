package com.example.penaltyshootout

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.penaltyshootout.R.id
import com.example.penaltyshootout.R.id.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.json.JSONArray
import kotlin.collections.toMutableList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var leaderboard : Leaderboard
    private lateinit var leaderboardButton : TextView
    private lateinit var home : TextView
    private lateinit var play : TextView
    private lateinit var playButton : TextView
    private lateinit var recyclerView : RecyclerView
    private lateinit var databaseRef : DatabaseReference
    private lateinit var pref : SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = this.getSharedPreferences(this.packageName + "_preferences", Context.MODE_PRIVATE )
        databaseRef = FirebaseDatabase.getInstance().getReference("leaderboard")
        leaderboard = Leaderboard(this, databaseRef)
        databaseRef.addValueEventListener(leaderboard)
        leaderboard.start()
        playButton = findViewById<TextView>(play_button)
        leaderboardButton = findViewById<TextView>(leaderboard_button)
        leaderboardButton.setOnClickListener(this)
        playButton.setOnClickListener(this)
    }

    override fun onClick(v : View?){
        when (v?.id){
            play_button -> { startPlay() }
            leaderboard_button -> { openLeaderboard() }
//            play -> {  }
            R.id.home -> { setContentView(R.layout.activity_main) }

        }
    }

    fun startPlay(){
        var intent = Intent(this, Game::class.java)
        startActivity(intent)
    }

    fun openLeaderboard(){
        setContentView(R.layout.leaderboard)
        recyclerView = findViewById(R.id.recyclerView)
        home = findViewById<TextView>(R.id.home)
        play = findViewById<TextView>(R.id.play)
        home.setOnClickListener(this)
        play.setOnClickListener(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var getRes = leaderboard.getLeaderboard()
        if(getRes.get(0).get(1) == ""){
            getRes = List<List<String>>(20, {List<String>(3, {"0"})})
        }
        recyclerView.adapter = MyAdapter(getRes)

    }
}