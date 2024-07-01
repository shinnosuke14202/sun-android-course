package com.example.suncourse.fragment_lifecycle

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityFragmentE4Binding

class FragmentE4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentE4Binding
    private lateinit var detailFragment: DetailFragment
    private var opened = false

    // Not use recycler view so only demo title/issue 1 and 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentE4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        detailFragment = DetailFragment.newInstance {
            closeFragment()
        }

        binding.apply {

            ll1.setOnClickListener {
                addFragment(tvTitle1.text.toString())
            }

            ll2.setOnClickListener {
                addFragment(tvTitle2.text.toString())
            }

        }

    }

    private fun closeFragment() {
        supportFragmentManager.beginTransaction().remove(detailFragment).commit()
        binding.flFragmentContainer.visibility = View.GONE
    }

    private fun addFragment(text: String) {
        binding.apply {
            if (opened) {
                detailFragment = DetailFragment.newInstance {
                    closeFragment()
                }
                detailFragment.arguments = bundleOf("title" to text)
                supportFragmentManager.beginTransaction()
                    .replace(flFragmentContainer.id, detailFragment).commit()
            } else {
                opened = true
                if (tvChoose != null) {
                    tvChoose.visibility = View.GONE
                }
                detailFragment.arguments = bundleOf("title" to text)
                supportFragmentManager.beginTransaction()
                    .add(flFragmentContainer.id, detailFragment)
                    .addToBackStack(null).commit()
            }
            flFragmentContainer.visibility = View.VISIBLE
        }
    }

}