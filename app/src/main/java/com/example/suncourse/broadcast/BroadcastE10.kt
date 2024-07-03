package com.example.suncourse.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastE10 : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val data = intent?.getStringExtra(BroadcastActivity.INTENT_KEY)
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show()
    }

}