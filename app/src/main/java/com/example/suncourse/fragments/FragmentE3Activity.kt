package com.example.suncourse.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityFragmentE3Binding

class FragmentE3Activity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFragmentE3Binding.inflate(layoutInflater)
    }

    private lateinit var feedbackFragment: FeedbackFragment
    private var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            //val fbFragment = supportFragmentManager.findFragmentById(R.id.fE3) as? FeedbackFragment
            feedbackFragment = FeedbackFragment()

            btnOpen.setOnClickListener {
                if (!isOpen) {
                    isOpen = true
                    btnOpen.text = "OPEN"
                    supportFragmentManager.beginTransaction()
                        .add(binding.flFragmentContainer.id, feedbackFragment).addToBackStack(null)
                        .commit()
                }
                else {
                    isOpen = false
                    btnOpen.text = "CLOSE"
                    supportFragmentManager.beginTransaction().remove(feedbackFragment).commit()
                }
            }

        }

    }
}