package com.example.suncourse.recycler_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRecyclerViewBinding.inflate(layoutInflater)
    }

    private lateinit var textList : MutableList<String>
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapterE8: RecyclerViewAdapterE8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
        initRecyclerView()

        binding.apply {
            btnAdd.setOnClickListener {
                adapterE8.addItem("Word ${textList.size + 1}")
            }
        }

    }

    private fun initRecyclerView() {
        recyclerView = binding.rvE8
        recyclerView.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
        adapterE8 = RecyclerViewAdapterE8(textList)
        recyclerView.adapter = adapterE8

        adapterE8.onItemClick = {
            val text = textList[it]
            textList[it] = "Clicked! $text"
        }

    }

    private fun initData() {
        textList = mutableListOf(
            "Word 1",
            "Word 2",
            "Word 3",
            "Word 4"
        )
    }

}