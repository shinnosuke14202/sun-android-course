package com.example.suncourse.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PowerConnectionBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            when (intent.action) {
                Intent.ACTION_POWER_CONNECTED -> Toast.makeText(
                    context,
                    "BATTERY PLUGGED IN",
                    Toast.LENGTH_LONG
                ).show()

                Intent.ACTION_POWER_DISCONNECTED -> Toast.makeText(
                    context,
                    "BATTERY UNPLUGGED",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}