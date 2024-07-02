package com.example.suncourse.menus_and_pickers

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityDroidCafeBinding

class DroidCafeActivity : AppCompatActivity() {

    // demo when click item 1

    private val binding by lazy {
        ActivityDroidCafeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.tbDroidCafe)

        binding.apply {
            ll1.setOnClickListener {
                val intent = Intent(this@DroidCafeActivity, DetailDFActivity::class.java)
                intent.putExtra("FOOD", "Cake")
                startActivity(intent)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.droid_cafe_menu, menu)
        return true
    }



}