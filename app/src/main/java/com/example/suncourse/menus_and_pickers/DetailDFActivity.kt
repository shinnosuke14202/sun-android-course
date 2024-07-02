package com.example.suncourse.menus_and_pickers

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.suncourse.R
import com.example.suncourse.databinding.ActivityDetailDfactivityBinding

class DetailDFActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailDfactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailDfactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getStringExtra("FOOD")

        val customLabels = listOf("Home", "Work", "Other", "Custom")
        val adapter = ArrayAdapter(
            this@DetailDFActivity,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            customLabels
        )

        binding.apply {

            val orderMessage = "You ordered a $food"
            tvOrdered.text = orderMessage

            // radio group
            rgDetailDF.setOnCheckedChangeListener { _, checkedId ->
                val option = findViewById<RadioButton>(checkedId)
                when (option) {
                    rbPickUp -> Toast.makeText(
                        this@DetailDFActivity,
                        rbPickUp.text.toString(),
                        Toast.LENGTH_SHORT
                    ).show()

                    rbNextDay -> Toast.makeText(
                        this@DetailDFActivity,
                        rbNextDay.text.toString(),
                        Toast.LENGTH_SHORT
                    ).show()

                    rbSameDay -> Toast.makeText(
                        this@DetailDFActivity,
                        rbSameDay.text.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // spinner
            spLabels.adapter = adapter
            spLabels.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (adapterView != null) {
                        Toast.makeText(
                            this@DetailDFActivity,
                            "You selected ${adapterView.getItemAtPosition(position)}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

        }


    }

}