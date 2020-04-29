package com.example.fsa



import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Pause: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Pause ", Toast.LENGTH_SHORT).show()
    }
}