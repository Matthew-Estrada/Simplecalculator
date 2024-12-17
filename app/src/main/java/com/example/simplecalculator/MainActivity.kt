package com.example.simplecalculator

import android.os.Bundle
import android.text.InputFilter
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1Input = findViewById<TextInputEditText>(R.id.textInputEditText1)
        val number2Input = findViewById<TextInputEditText>(R.id.textInputEditText2)
        val resultText = findViewById<TextView>(R.id.result)

        val addButton = findViewById<Button>(R.id.add)
        val subtractButton = findViewById<Button>(R.id.subtract)
        val multiplyButton = findViewById<Button>(R.id.multiply)
        val divideButton = findViewById<Button>(R.id.divide)

        val filter = InputFilter { source, start, end, dest, dstart, dend ->
            val filtered = source.toString().replace(Regex("[^0-9.]"), "")
            if (filtered.count { it == '.' } > 1) {
                return@InputFilter ""
            }
            filtered
        }

        number1Input.filters = arrayOf(filter)
        number2Input.filters = arrayOf(filter)

        addButton.setOnClickListener {
            val num1 = number1Input.text.toString().toDoubleOrNull()
            val num2 = number2Input.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                resultText.text = "Result: ${num1 + num2}"
            } else {
                resultText.text = "Invalid input"
            }
        }

        subtractButton.setOnClickListener {
            val num1 = number1Input.text.toString().toDoubleOrNull()
            val num2 = number2Input.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                resultText.text = "Result: ${num1 - num2}"
            } else {
                resultText.text = "Invalid input"
            }
        }

        multiplyButton.setOnClickListener {
            val num1 = number1Input.text.toString().toDoubleOrNull()
            val num2 = number2Input.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                resultText.text = "Result: ${num1 * num2}"
            } else {
                resultText.text = "Invalid input"
            }
        }

        divideButton.setOnClickListener {
            val num1 = number1Input.text.toString().toDoubleOrNull()
            val num2 = number2Input.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    resultText.text = "Result: ${num1 / num2}"
                } else {
                    resultText.text = "Cannot divide by zero"
                }
            } else {
                resultText.text = "Invalid input"
            }
        }
    }
}
