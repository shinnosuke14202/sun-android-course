package com.example.suncourse.drawable_styles_themes

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityE5Binding

class E5Activity : AppCompatActivity() {

    private val binding by lazy {
        ActivityE5Binding.inflate(layoutInflater)
    }

    private var isDarkMode = false
    private var scoreT1 = 0
    private var scoreT2 = 0
    private lateinit var  sharePref : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharePref = getSharedPreferences("myPref", MODE_PRIVATE)
        editor = sharePref.edit()

        isDarkMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        scoreT1 = sharePref.getInt("SCORE_T1", 0)
        scoreT2 = sharePref.getInt("SCORE_T2", 0)

        binding.apply {

            tvScoreT1.text = scoreT1.toString()
            tvScoreT2.text = scoreT2.toString()

            btnPlusT1.setOnClickListener {
                scoreT1 = tvScoreT1.text.toString().toInt() + 1
                tvScoreT1.text = scoreT1.toString()
            }
            btnPlusT2.setOnClickListener {
                scoreT2 = tvScoreT2.text.toString().toInt() + 1
                tvScoreT2.text = scoreT2.toString()
            }
            btnMinusT1.setOnClickListener {
                scoreT1 = tvScoreT1.text.toString().toInt() - 1
                if (scoreT1 < 0) scoreT1 = 0
                tvScoreT1.text = (scoreT1).toString()
            }
            btnMinusT2.setOnClickListener {
                scoreT2 = tvScoreT2.text.toString().toInt() - 1
                if (scoreT2 < 0) scoreT2 = 0
                tvScoreT2.text = (scoreT2).toString()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.e5_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miDarkMode -> {
                binding.apply {
                    applyDarkMode()
                    saveScores()
                }
            }
        }
        return true
    }

    private fun saveScores()  {
        editor.apply {
            putBoolean("DARK_MODE", isDarkMode)
            putInt("SCORE_T1", scoreT1)
            putInt("SCORE_T2", scoreT2)
            apply()
        }
    }

    private fun applyDarkMode() {
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Toast.makeText(this@E5Activity, "Enable Light Mode", Toast.LENGTH_SHORT).show()
            isDarkMode = false
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Toast.makeText(this@E5Activity, "Enable Dark Mode", Toast.LENGTH_SHORT).show()
            isDarkMode = true
        }
    }

//    override fun onStop() {
//        super.onStop()
//        editor.apply {
//            remove("SCORE_T1")
//            remove("SCORE_T2")
//            apply()
//        }
//    }

}