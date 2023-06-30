package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var countDownTimer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerTextView: TextView = findViewById(R.id.timer)
        val initialTimeMillis: Long = 120000 // Waktu awal dalam milidetik (01:59 = 119000 milidetik)

        countDownTimer = object : CountDownTimer(initialTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60
                val formattedTime = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
                timerTextView.text = formattedTime
            }

            override fun onFinish() {
                timerTextView.setText(R.string.countdown_finished)
                // Aksi yang ingin dilakukan ketika countdown selesai
            }
        }

        countDownTimer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }
    }
