package com.example.suncourse.implicit_intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityIntentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {

            btnOpenWebsite.setOnClickListener {
                val websiteUrl = etWebsite.text.toString()
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse(websiteUrl)
                startActivity(intent)
            }

            btnOpenLocation.setOnClickListener {
                val location = "https://www.google.com/maps?q=" + etLocation.text.toString()
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location))
                startActivity(intent)
            }

            btnShareText.setOnClickListener {
                val text = etText.text.toString()
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.setDataAndType(Uri.parse(text),"text/plain")
                startActivity(intent)
            }

        }
    }
}