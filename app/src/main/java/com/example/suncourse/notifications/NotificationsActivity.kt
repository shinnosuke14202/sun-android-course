package com.example.suncourse.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityNotificationsBinding

class NotificationsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNotificationsBinding.inflate(layoutInflater)
    }

    private lateinit var manager: NotificationManager
    private lateinit var broadcast: BroadcastReceiver
    private var notificationId : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        broadcast = NotificationUpdateReceiver().apply {
            onTrigger = {
                updateNotification()
            }
        }

        val intentFilter = IntentFilter(UPDATE_NOTIFICATION)
        registerReceiver(broadcast, intentFilter)

        createNotificationChannel()

        binding.apply {
            btnNotify.setOnClickListener {
                createNotification()
            }
            btnUpdate.setOnClickListener {
                updateNotification()
            }
            btnCancel.setOnClickListener {
                notificationId?.let { it1 -> manager.cancel(it1) }
                notificationId = null
            }
        }

    }

    private fun createPendingIntent() : PendingIntent? {
        val intent = Intent(this@NotificationsActivity, NotificationsActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this@NotificationsActivity).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE)
        }
        return pendingIntent
    }

    private fun updatePendingIntent() : PendingIntent? {
        val intent = Intent()
        intent.action = UPDATE_NOTIFICATION
        val pendingIntent = PendingIntent.getBroadcast(this@NotificationsActivity, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        return pendingIntent
    }

    private fun createNotification() {
        notificationId = 0
        val pendingIntent = createPendingIntent()
        val updatePendingIntent = updatePendingIntent()
        val notification = NotificationCompat.Builder(this@NotificationsActivity, CHANNEL_ID)
            .setContentTitle("You've been notified!")
            .setContentText("This is your notification text.")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.baseline_crisis_alert_24, "UPDATE NOTIFICATION", updatePendingIntent)
            .build()
        manager.notify(0, notification)
    }

     private fun updateNotification() {
        if (notificationId != null) {
            val pendingIntent = createPendingIntent()
            val updatedNotification = NotificationCompat.Builder(this@NotificationsActivity, CHANNEL_ID)
                .setContentTitle("Notification have been updated")
                .setContentText("This is your updated notification text.")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build()
            manager.notify(notificationId!!, updatedNotification)
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )
            manager.createNotificationChannel(channel)
        }
    }

    companion object {
        const val CHANNEL_ID = "CHANNEL_ID"
        const val CHANNEL_NAME = "CHANNEL_NAME"
        const val UPDATE_NOTIFICATION = "UPDATE_NOTIFICATION"
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcast)
    }


}
