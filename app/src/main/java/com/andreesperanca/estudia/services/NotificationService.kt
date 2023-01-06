package com.andreesperanca.estudia.services

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.andreesperanca.estudia.MainActivity
import com.andreesperanca.estudia.R

private const val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
    val contentIntent = Intent(applicationContext, MainActivity::class.java)
    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
    )
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.estudia_notification_channel_id)
    )
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setColor(R.color.primaryColor)
        .setContentTitle(
            applicationContext
                .getString(R.string.endOfCycle)
        )
        .setContentText(messageBody)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_HIGH)

    notify(NOTIFICATION_ID, builder.build())
}
