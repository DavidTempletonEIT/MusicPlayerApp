package com.example.fsa


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Play: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Play ", Toast.LENGTH_SHORT).show()
    }
}