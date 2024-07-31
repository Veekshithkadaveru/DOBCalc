package com.example.dobcalculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicker: Button = findViewById(R.id.buttonDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        datePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(
            this,
            { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(
                    this,
                    "Year was $selectedYear,month was ${selectedMonth + 1},day of month was $selectedDayOfMonth",
                    Toast.LENGTH_LONG
                ).show()
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate?.text = selectedDate
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
            },
            year, month, day
        ).show()
    }
}
