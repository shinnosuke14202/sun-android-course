package com.example.suncourse.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationUpdateReceiver : BroadcastReceiver() {

    lateinit var onTrigger : () -> Unit

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == NotificationsActivity.UPDATE_NOTIFICATION) {
            onTrigger.invoke()
        }
    }

}