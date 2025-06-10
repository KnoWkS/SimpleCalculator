package com.example.simplecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nb1 = findViewById<EditText>(R.id.Nb1)
        val nb2 = findViewById<EditText>(R.id.Nb2)
        val operator = findViewById<Spinner>(R.id.Operator_spinner)
        val button = findViewById<Button>(R.id.Calculate)
        val result = findViewById<TextView>(R.id.ResultText)

        val adapter = ArrayAdapter.createFromResource(this,R.array.operators_array , android.R.layout.simple_spinner_item)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                operator.adapter = adapter
        button.setOnClickListener {
            val number1 = nb1.text.toString().toDoubleOrNull()
            val number2 = nb2.text.toString().toDoubleOrNull()
            val op = operator.selectedItem.toString()
            if (number1 == null || number2 == null) {
                result.text = "Please enter valid numbers."
                return@setOnClickListener
            }
            if(number2 ==0.0 && op =="/") {
                result.text = "Divide by zero error"
                return@setOnClickListener
            }
            val res = when (op) {
                    "+" -> number1 + number2
                    "-" -> number1 - number2
                    "*" -> number1 * number2
                    "/" -> number1 / number2
                    else -> {
                        result.text = "Invalid operator"
                        return@setOnClickListener
                    }
            }
            result.text = "Résultat : $res"
        }
    }
}

