package com.mohirdev.mapbox

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi

class LocationService : Service() {

    private val CHANNEL_ID = "CHANNEL_ID"

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val channel = NotificationChannel(
            CHANNEL_ID,
            "ChannelName",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.lightColor = Color.BLUE
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(channel)
        val notification = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("Location")
            .setContentText("App get user location")
            .setSmallIcon(R.drawable.ic_stat_name)
            .setCategory(Notification.CATEGORY_CALL)
            .build()
        startForeground(1111,notification)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}