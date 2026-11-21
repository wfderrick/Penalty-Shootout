package com.example.penaltyshootout

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.json.JSONArray

class Leaderboard : ValueEventListener {

    private lateinit var leaderboard : List<List<String>>

//    constructor(ref : DatabaseReference){
//
//    }
    override fun onDataChange(snapshot: DataSnapshot) {
        var json = JSONArray(snapshot.value.toString())
        var editable = leaderboard.toMutableList()
        for (i in 0 until leaderboard.size){
            var innerEdit = editable[i].toMutableList()
            var innerJSON = JSONArray(json.get(i))
            innerEdit[1] = innerJSON.getString(1)
            innerEdit[2] = innerJSON.getInt(2).toString()
            editable[i] = innerEdit
        }
        leaderboard = editable
    }

    override fun onCancelled(error: DatabaseError) {
        Log.w("Leaderboard", error.code.toString())
    }

    fun getLeaderboard() : List<List<String>>{
        leaderboard = List<List<String>>(20, {List(3, {"0"})})
        return leaderboard
    }
//    fun newScore(username : String, score : Int, ref : DatabaseReference){
//        var editable = leaderboard.toMutableList()
//        var result = editable
//        var i = 0
//        while (i < leaderboard.size){
//            if (score > editable[i][2].toInt()){
//                result = (editable.subList(0, i) + arrayOf("0", username, score.toString()) + editable.subList(i, leaderboard.size))  as MutableList<Array<String>>
//                break
//            }
//            i++
//        }
//        if (result.size > 20){
//            result = result.subList(0, result.size - 1)
//        }
//        ref.setValue(result)
//    }


}