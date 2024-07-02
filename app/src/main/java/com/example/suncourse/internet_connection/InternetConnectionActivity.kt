package com.example.suncourse.internet_connection

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityInternetConnectionBinding
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.Executors

class InternetConnectionActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInternetConnectionBinding.inflate(layoutInflater)
    }

    private lateinit var data: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnSearchBookInfo.setOnClickListener {
                getBookInfo()
            }
        }

    }

    private fun getBookInfo() {
        val currentText = binding.etBookName.text
        val executors = Executors.newSingleThreadExecutor()
        executors.execute {
            data = FetchApi.getData("volumes?q=$currentText&projection=lite")
            runOnUiThread {
                binding.tvBookInfo.text = getDesiredData(data)
            }
        }

    }

    private fun getDesiredData(data: String) : String {
        val desiredData = StringBuilder()
        val itemsArray = JSONObject(data).getJSONArray("items")
        for (i in 0..<itemsArray.length()) {
            desiredData.append("Option $i: ")
            var title = "?"
            var author = "?"
            val item = itemsArray.getJSONObject(i)
            val volumeInfo = item.getJSONObject("volumeInfo")
            if (volumeInfo.has("title") ) {
                title = volumeInfo.getString("title")
            }
            if (volumeInfo.has("authors") ) {
                author = volumeInfo.getString("authors")
            }
            desiredData.append("Title is [$title] and Authors are $author \n\n")
        }
        return desiredData.toString()
    }
}
