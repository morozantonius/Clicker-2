package com.morozantonius.clicker2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class   InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        findViewById<Button>(R.id.back2endButton).setOnClickListener {
            finish()
        }
    }
}