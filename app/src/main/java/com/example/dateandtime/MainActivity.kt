package com.example.dateandtime

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dateandtime.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        binding.btnDate.setOnClickListener {
            showDate()

        }

        binding.btnTime.setOnClickListener {
            showTime()
        }
    }

    private fun showTime() {
        val time = LayoutInflater.from(this).inflate(R.layout.time_picker,null)
        val idTime = time.findViewById<TimePicker>(R.id.tp_time)
        val alertDialog = AlertDialog.Builder(this).setView(time)
        idTime.setOnTimeChangedListener { _, hour, minute ->
            val hour = hour
            val message = "Time is: $hour:$minute"
            binding.tvTime.text = message
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

        }

        val alertShow = alertDialog
        alertShow.show()
    }

    private fun showDate() {
        val calendar = Calendar.getInstance()
        val date = LayoutInflater.from(this).inflate(R.layout.date_picker, null)
        val id = date.findViewById<DatePicker>(R.id.dp_picker)
        val alertDialog = AlertDialog.Builder(this).setView(date)
        id.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You selected: $day/$month/$year"
            binding.tvDate.text = msg
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        val alert = alertDialog
        alert.show()
    }
    }


