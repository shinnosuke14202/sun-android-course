package com.example.suncourse.user_navigation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.suncourse.databinding.ActivityTabNavigationBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabNavigationActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTabNavigationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tabTexts = listOf(
            "TOP STORIES",
            "TECH NEWS",
            "COOKING"
        )

        val list = listOf(
            "There are the top stories:",
            "Tech news you can use:",
            "Cooking tips:"
        )

        val adapter = ViewPagerAdapter(list)

        binding.apply {
            viewPager.adapter = adapter
            viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = tabTexts[position]
            }.attach()

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    Toast.makeText(this@TabNavigationActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    Toast.makeText(this@TabNavigationActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT).show()
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    Toast.makeText(this@TabNavigationActivity, "Reselected ${tab?.text}", Toast.LENGTH_SHORT).show()
                }

            })

        }

    }
}