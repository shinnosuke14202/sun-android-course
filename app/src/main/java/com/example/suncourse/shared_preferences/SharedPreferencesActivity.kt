package com.example.suncourse.shared_preferences

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySharedPreferencesBinding.inflate(layoutInflater)
    }

    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    private lateinit var currentColor : String
    private var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        count = sharedPreferences.getInt(COUNT, 0)
        currentColor = sharedPreferences.getString(CURRENT_COLOR, "#FFD5D2D2").toString()

        binding.apply {

            tvCount.text = count.toString()
            tvCount.setBackgroundColor(Color.parseColor(currentColor))

            btnCount.setOnClickListener {
                count += 1
                editor.apply {
                    putInt(COUNT, count)
                    commit()
                }
                tvCount.text = count.toString()
            }
            tvBlack.setOnClickListener {
                tvCount.setBackgroundColor(Color.parseColor("#FF222222"))
                editor.apply {
                    putString(CURRENT_COLOR, "#FF222222")
                    commit()
                }
            }
            tvRed.setOnClickListener {
                tvCount.setBackgroundColor(Color.parseColor("#FFC52525"))
                editor.apply {
                    putString(CURRENT_COLOR, "#FFC52525")
                    commit()
                }
            }
            tvBlue.setOnClickListener {
                tvCount.setBackgroundColor(Color.parseColor("#FF3F92D6"))
                editor.apply {
                    putString(CURRENT_COLOR, "#FF3F92D6")
                    commit()
                }
            }
            tvGreen.setOnClickListener {
                tvCount.setBackgroundColor(Color.parseColor("#FF2EB533"))
                editor.apply {
                    putString(CURRENT_COLOR, "#FF2EB533")
                    commit()
                }
            }
            btnReset.setOnClickListener {
                count = 0
                tvCount.text = count.toString()
                tvCount.setBackgroundColor(Color.parseColor("#FFD5D2D2"))
                editor.apply {
                    remove(CURRENT_COLOR)
                    remove(COUNT)
                    commit()
                }
            }
        }

    }

    companion object {
        const val COUNT = "COUNT"
        const val CURRENT_COLOR = "CURRENT_COLOR"
    }

}