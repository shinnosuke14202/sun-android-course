package com.example.suncourse.activities_and_intents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.suncourse.databinding.ActivityE1MainBinding

class E1MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityE1MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityE1MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btnSend.setOnClickListener {
                val message = etText.text.toString()
                val intent = Intent(this@E1MainActivity, E2SecondActivity::class.java)
                intent.putExtra("message", message)
                onActivityResultLauncher.launch(intent)
            }
        }

    }

    private val onActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                data?.getStringExtra("reply")?.let {
                    binding.tvReply.text = it
                    binding.llTop.visibility = View.VISIBLE
                }
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this@E1MainActivity, "Result Cancelled", Toast.LENGTH_SHORT).show()
            }
        }


}