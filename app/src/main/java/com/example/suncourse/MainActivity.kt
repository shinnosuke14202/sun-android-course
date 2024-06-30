package com.example.suncourse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suncourse.activities_and_intents.E1MainActivity
import com.example.suncourse.databinding.ActivityMainBinding
import com.example.suncourse.implicit_intents.IntentActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnHW1.setOnClickListener {
                val intent = Intent(this@MainActivity, E1MainActivity::class.java)
                startActivity(intent)
            }
            btnHW2.setOnClickListener {
                val intent = Intent(this@MainActivity, IntentActivity::class.java)
                startActivity(intent)
            }
        }
    }

}