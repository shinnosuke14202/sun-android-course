package com.example.suncourse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suncourse.activities_and_intents.E1MainActivity
import com.example.suncourse.databinding.ActivityMainBinding
import com.example.suncourse.drawable_styles_themes.E5Activity
import com.example.suncourse.fragment_lifecycle.FragmentE4Activity
import com.example.suncourse.fragments.FragmentE3Activity
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
            btnHW3.setOnClickListener {
                val intent = Intent(this@MainActivity, FragmentE3Activity::class.java)
                startActivity(intent)
            }
            btnHW4.setOnClickListener {
                val intent = Intent(this@MainActivity, FragmentE4Activity::class.java)
                startActivity(intent)
            }
            btnHW5.setOnClickListener {
                val intent = Intent(this@MainActivity, E5Activity::class.java)
                startActivity(intent)
            }
        }
    }

}