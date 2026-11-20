package com.example.penaltyshootout

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Leaderboard: AppCompatActivity(), ValueEventListener{

    private lateinit var leaderboardView : LeaderboardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leaderboardView = LeaderboardView(this, getLeaderboard())
        setContentView(leaderboardView)
        leaderboardView.postInvalidate()
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        TODO("Not yet implemented")
    }

    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }

    fun getLeaderboard() : Array<Array<String>>{
        var firebase = FirebaseDatabase.getInstance()
        var ref = firebase.getReference("leaderboard")
        var test = ref.toString()
        Log.w("Leaderboard", test)

        var res = Array<Array<String>>(20, {Array<String>(3, {""})})
        return res
    }


}