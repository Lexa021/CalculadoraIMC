package com.example.calculadoraimc

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var heightEditText: EditText
    lateinit var weightTextView: TextView
    lateinit var minusButton: Button
    lateinit var addButton: Button
    lateinit var descriptionTextView: TextView
    lateinit var resultTextView: TextView
    lateinit var calculateButton: Button

    var height: Int = 150
    var weight: Int = 70

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightEditText = findViewById(R.id.heightEditText)
        weightTextView = findViewById(R.id.weightTextView)
        minusButton = findViewById(R.id.minusButton)
        addButton = findViewById(R.id.addButton)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        resultTextView = findViewById(R.id.resultTextView)
        calculateButton = findViewById(R.id.calculateButton)

        setHeight()
        setWeight()

        minusButton.setOnClickListener {
            weight--
            setWeight()
        }

        addButton.setOnClickListener {
            weight++
            setWeight()
        }

        /**calculateButton.setOnClickListener {
        height = heightEditText.text.toString().toInt()

        val result = weight / (height / 100f).pow(2)

        resultTextView.text = result.toString()
        }**/
        calculateButton.setOnClickListener {
            val heightText = heightEditText.text.toString()
            if (heightText.isNotEmpty()) {
                val height = heightText.toDouble() / 100 // Convertir cm a metros
                val bmi = weight / (height * height)
                resultTextView.text = String.format("%.2f", bmi)
                //val result = weight / (height / 100f).pow(2)
                //resultTextView.text = result.toString()

                descriptionTextView.text = getBMIDescription(bmi)
            } else {
                heightEditText.error = "Por favor, ingrese su altura"
            }
        }
    }

    fun setHeight() {
        heightEditText.setText(height.toString())
    }

    fun setWeight() {
        weightTextView.text = "$weight Kg"
    }

    private fun getBMIDescription(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Peso bajo"
            bmi in 18.5..24.9 -> "Peso normal"
            bmi in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }
}