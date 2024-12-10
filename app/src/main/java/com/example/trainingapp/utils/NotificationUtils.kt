package com.example.trainingapp.utils

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

/**
 * Notification utils
 * Manages notifications stuff
 * @constructor Create empty Notification utils
 */
object NotificationUtils {
    /**
     * Generate OTP
     *
     * @return
     */
    fun generateOTP(): String {
        return Random.nextInt(1000, 9999).toString()
    }

    /**
     * Show notification
     *
     * @param context
     * @param otp
     */
    @SuppressLint("MissingPermission")
    fun showNotification(context: Context, otp: String) {
        val channelId = "otp_channel"
        val channelName = "OTP Notifications"

        // Create a notification channel for Android O and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = "Channel for OTP notifications"
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        // Create a notification
        val notification: Notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Your OTP Code").setContentText("Your OTP is: $otp")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        // Show the notification
        with(NotificationManagerCompat.from(context)) {
            notify(1, notification)
        }
    }
}