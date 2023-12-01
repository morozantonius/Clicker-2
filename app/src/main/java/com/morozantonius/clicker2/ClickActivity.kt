package com.morozantonius.clicker2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val bestResultTextView = findViewById<TextView>(R.id.bestResultTextView)
        val bestResult = sharedPreferences.getInt("bestResult", 0)
        bestResultTextView.text = "Record: $bestResult"

        findViewById<ImageButton>(R.id.eyeButton).setOnClickListener {
            val clickIntent: Intent = Intent(this, InfoActivity::class.java)
            startActivity(clickIntent)
        }
        findViewById<MaterialButton>(R.id.clickButton).setOnClickListener {
            val clickIntent: Intent = Intent(this, GoActivity::class.java)
            startActivity(clickIntent)
        }
    }
}
