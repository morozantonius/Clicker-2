package com.morozantonius.clicker2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class GoActivity : AppCompatActivity() {
    private lateinit var timerView: TextView
    private lateinit var numbersView: TextView
    private var number = 0
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_go)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        timerView = findViewById(R.id.timerView)
        numbersView = findViewById(R.id.numbersView)

        val goButton = findViewById<Button>(R.id.goButton)
        goButton.setOnClickListener {
            number++
            numbersView.text = number.toString()
        }

        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerView.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                val intent = Intent(this@GoActivity, EndActivity::class.java)
                intent.putExtra("number", number)

                val bestResult = sharedPreferences.getInt("bestResult", 0)
                if (number > bestResult) {
                    val editor = sharedPreferences.edit()
                    editor.putInt("bestResult", number)
                    editor.apply()

                    val toast = Toast.makeText(this@GoActivity, "NEW RECORD!", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.BOTTOM, 0, 0)
                    toast.show()
                }

                startActivity(intent)
                finish()
            }
        }.start()
    }
}
