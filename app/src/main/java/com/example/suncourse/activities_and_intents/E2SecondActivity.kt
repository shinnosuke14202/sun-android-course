package com.example.suncourse.activities_and_intents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.suncourse.databinding.ActivityE2SecondBinding

class E2SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityE2SecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityE2SecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val message = intent.getStringExtra("message")
            binding.tvMessage.text = message

            btnSend.setOnClickListener {
                val reply = etText.text.toString()
                val intent = Intent(this@E2SecondActivity, E1MainActivity::class.java)
                intent.putExtra("reply", reply)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        }

    }

}