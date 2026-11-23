package com.example.penaltyshootout

import com.google.android.gms.tasks.Tasks
import com.google.firebase.database.DatabaseReference

class DataRetrievalThread : Thread {
    private var activity : MainActivity
    private var databaseRef : DatabaseReference

    constructor(activity : MainActivity, databaseRef : DatabaseReference){
        this.activity = activity
        this.databaseRef = databaseRef
    }

    override fun run(){
        val snapshot = Tasks.await(databaseRef.get())
        val data = snapshot.value



    }
}