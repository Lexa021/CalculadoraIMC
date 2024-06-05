package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var welcomeTextView : TextView
    lateinit var clickButton: Button
    lateinit var clickButton2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeTextView = findViewById(R.id.welcomeTextView)
        clickButton = findViewById(R.id.clickButton)
        clickButton2 = findViewById(R.id.clickButton2)

        welcomeTextView.text = "Participa en el sorteo"

        clickButton.setOnClickListener({
            welcomeTextView.text = "Has ganado 1.000€"
        })
        clickButton2.setOnClickListener({
            welcomeTextView.text = "Participa"
        })

    }
}