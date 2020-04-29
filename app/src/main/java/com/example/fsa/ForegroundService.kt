package com.example.fsa

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService : Service(){
   private val CHANNEL_ID = "ForegroundService Kotlin"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        createNotificationChannel()
        val notificationIntent = Intent(this, ForegroundService::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val pauseIntent = Intent(applicationContext, Next::class.java)
        val pausePendingIntent: PendingIntent = PendingIntent.getBroadcast(
            applicationContext, 0, pauseIntent, 0)
        val previousIntent = Intent(applicationContext, Previous::class.java)
        val previousPendingIntent: PendingIntent = PendingIntent.getBroadcast(
            applicationContext, 0, previousIntent, 0)
        val playIntent = Intent(applicationContext, Play::class.java)
        val playPendingIntent: PendingIntent = PendingIntent.getBroadcast(
            applicationContext, 0, playIntent, 0)
        val nextIntent = Intent(applicationContext, Next::class.java)
        val nextPendingIntent: PendingIntent = PendingIntent.getBroadcast(
            applicationContext, 0, nextIntent, 0)
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_play_arrow_black_24dp)
            .setContentTitle("David Music Player App")
            .setContentText("Current Song")
            .addAction(R.drawable.ic_skip_previous_black_24dp, "Previous", previousPendingIntent)
            .addAction(R.drawable.ic_pause_black_24dp, "Pause", pausePendingIntent)
            .addAction(R.drawable.ic_play_arrow_black_24dp, "Play", playPendingIntent)
            .addAction(R.drawable.ic_skip_next_black_24dp, "Next", nextPendingIntent)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
         startForeground(1, notification)
            return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val serviceChannel = NotificationChannel(CHANNEL_ID,"Foreground Service Kotlin",
                NotificationManager.IMPORTANCE_DEFAULT)
            val manager = getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }
}
