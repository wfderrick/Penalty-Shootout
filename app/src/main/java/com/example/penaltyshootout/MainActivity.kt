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
import kotlin.collections.toMutableList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var playButton : TextView
    private lateinit var leaderboard : Leaderboard
    private lateinit var leaderboardButton : TextView
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

    override fun onDestroy() {
        super.onDestroy()
        saveLeaderboardLocal()
    }

    override fun onClick(v : View?){
        when (v?.id){
            play_button -> { startPlay() }
            leaderboard_button -> { openLeaderboard() }
        }
    }

    fun retrieveSavedLeaderBoard() : List<List<String>>{
        pref.getString("leaderboard", null)
        return listOf(listOf("0","0","0"), listOf("0","0","0"),listOf("0","0","0"),listOf("0","0","0"),listOf("0","0","0"))
    }

//    fun getLeaderboardFromString(){
//        var editable = MutableList(20, {Array})
//
//    }

    fun saveLeaderboardLocal(){
        var editor = pref.edit()
        editor.putString("leaderboard", leaderboard.getLeaderboard().toString())
        editor.commit()
    }

    fun startPlay(){
        var intent = Intent(this, Game::class.java)
        startActivity(intent)
    }

    fun openLeaderboard(){
        setContentView(R.layout.leaderboard)
        recyclerView = findViewById(id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var getRes = leaderboard.getLeaderboard()
        if(getRes.get(0).get(1) == ""){
            getRes = this.retrieveSavedLeaderBoard()
        }
        recyclerView.adapter = MyAdapter(getRes)

    }
}