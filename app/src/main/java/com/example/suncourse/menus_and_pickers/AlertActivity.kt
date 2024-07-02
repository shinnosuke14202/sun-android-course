package com.example.suncourse.menus_and_pickers

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.suncourse.databinding.ActivityAlertBinding

class AlertActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAlertBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val alertDialog = createDialog()
        val datePicker = createDatePicker()

        binding.apply {
            btnAlert.setOnClickListener {
                alertDialog.show()
            }
            btnDate.setOnClickListener {
                datePicker.show()
            }
        }

    }

    private fun createDialog() : AlertDialog {
        return AlertDialog.Builder(this@AlertActivity)
            .setTitle("Alert")
            .setMessage("Click OK to continue, or NO to stop:")
            .setPositiveButton("OK") { _, _ ->
                // dialog interface , button id
                Toast.makeText(this@AlertActivity, "You click OK", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("CANCEL") { _, _ ->
                Toast.makeText(this@AlertActivity, "You click CANCEL", Toast.LENGTH_SHORT).show()
            }
            .create()
    }

    private fun createDatePicker() : DatePickerDialog {
        val dialog = DatePickerDialog(this@AlertActivity)
        dialog.setOnDateSetListener { _, year, month, dayOfMonth ->
            val datePicked = "You pick date: $dayOfMonth - $month - $year"
            binding.tvDate.text = datePicked
        }
        return dialog
    }

}
