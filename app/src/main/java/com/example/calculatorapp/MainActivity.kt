package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstNumber: EditText = findViewById(R.id.etFirstNumber)
        val etSecondNumber: EditText = findViewById(R.id.etSecondNumber)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)
        val tvResult: TextView = findViewById(R.id.tvResult)

        val listener = View.OnClickListener { view ->
            val firstNumber = etFirstNumber.text.toString().toDoubleOrNull()
            val secondNumber = etSecondNumber.text.toString().toDoubleOrNull()

            if (firstNumber == null || secondNumber == null) {
                tvResult.text = "Please enter valid numbers"
                return@OnClickListener
            }

            val result = when (view.id) {
                R.id.btnAdd -> firstNumber + secondNumber
                R.id.btnSubtract -> firstNumber - secondNumber
                R.id.btnMultiply -> firstNumber * secondNumber
                R.id.btnDivide -> {
                    if (secondNumber != 0.0) {
                        firstNumber / secondNumber
                    } else {
                        tvResult.text = "Cannot divide by zero"
                        return@OnClickListener
                    }
                }
                else -> 0.0
            }

            tvResult.text = "Result: $result"
        }

        btnAdd.setOnClickListener(listener)
        btnSubtract.setOnClickListener(listener)
        btnMultiply.setOnClickListener(listener)
        btnDivide.setOnClickListener(listener)
    }
}
