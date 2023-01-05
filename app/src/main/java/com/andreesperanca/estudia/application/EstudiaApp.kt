package com.andreesperanca.estudia.application

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import com.andreesperanca.estudia.R
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EstudiaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        createChannel(
            getString(R.string.egg_notification_channel_id),
            getString(R.string.egg_notification_channel_name)
        )
    }

    private fun createChannel(channelId: String, channelName: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                setShowBadge(false)
            }

            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = getString(R.string.channelDescription)

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}