package com.example.suncourse.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suncourse.databinding.ActivityBroadcastBinding

class BroadcastActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityBroadcastBinding.inflate(layoutInflater)
    }

    private lateinit var broadcast : BroadcastE10
    private lateinit var powerBroadcast : PowerConnectionBroadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        broadcast = BroadcastE10()
        val intentFilter = IntentFilter()
        intentFilter.addAction(ACTION)
        registerReceiver(broadcast, intentFilter)

        powerBroadcast = PowerConnectionBroadcast()
        val powerIntentFilter = IntentFilter()
        powerIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        powerIntentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(powerBroadcast, powerIntentFilter)

        binding.apply {
            btnSendBroadcast.setOnClickListener {
                sendBroadcast()
            }
        }


    }

    private fun sendBroadcast() {
        val intent = Intent()
        intent.action = ACTION
        intent.putExtra(INTENT_KEY, "CUSTOM BROADCAST RECEIVED")
        sendBroadcast(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcast)
        unregisterReceiver(powerBroadcast)
    }

    companion object {
        const val ACTION = "ACTION"
        const val INTENT_KEY = "INTENT_KEY"
    }

}