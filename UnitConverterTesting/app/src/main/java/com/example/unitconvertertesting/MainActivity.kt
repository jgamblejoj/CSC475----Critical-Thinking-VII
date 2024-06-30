package com.example.unitconvertertesting

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputValue = findViewById<EditText>(R.id.inputValue)
        val unitTypeSpinner = findViewById<Spinner>(R.id.unitTypeSpinner)
        val fromUnitSpinner = findViewById<Spinner>(R.id.fromUnitSpinner)
        val toUnitSpinner = findViewById<Spinner>(R.id.toUnitSpinner)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        unitTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val unitType = unitTypeSpinner.selectedItem.toString()
                val unitArrayId = when (unitType) {
                    "Temperature" -> R.array.temperature_units
                    "Length" -> R.array.length_units
                    "Weight" -> R.array.weight_units
                    else -> R.array.empty_array
                }
                ArrayAdapter.createFromResource(
                    this@MainActivity,
                    unitArrayId,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    fromUnitSpinner.adapter = adapter
                    toUnitSpinner.adapter = adapter
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        convertButton.setOnClickListener {
            val value = inputValue.text.toString().toDoubleOrNull()
            if (value != null) {
                val fromUnit = fromUnitSpinner.selectedItem.toString()
                val toUnit = toUnitSpinner.selectedItem.toString()
                val result = when (unitTypeSpinner.selectedItem.toString()) {
                    "Temperature" -> temperatureUnitConversion(value, fromUnit, toUnit)
                    "Length" -> lengthUnitConversion(value, fromUnit, toUnit)
                    "Weight" -> weightUnitConversion(value, fromUnit, toUnit)
                    else -> 0.0
                }
                resultTextView.text = "Result: $result"
            } else {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Temperature conversion functions
    private fun temperatureUnitConversion(value: Double, fromUnit: String, toUnit: String): Double {
        return when (fromUnit to toUnit) {
            "Celsius" to "Fahrenheit" -> celsiusToFahrenheit(value)
            "Celsius" to "Kelvin" -> celsiusToKelvin(value)
            "Fahrenheit" to "Celsius" -> fahrenheitToCelsius(value)
            "Fahrenheit" to "Kelvin" -> fahrenheitToKelvin(value)
            "Kelvin" to "Celsius" -> kelvinToCelsius(value)
            "Kelvin" to "Fahrenheit" -> kelvinToFahrenheit(value)
            else -> value // No conversion needed
        }
    }

    // Length conversion functions
    private fun lengthUnitConversion(value: Double, fromUnit: String, toUnit: String): Double {
        return when (fromUnit to toUnit) {
            "Meters" to "Feet" -> metersToFeet(value)
            "Meters" to "Inches" -> metersToInches(value)
            "Feet" to "Meters" -> feetToMeters(value)
            "Feet" to "Inches" -> feetToInches(value)
            "Inches" to "Meters" -> inchesToMeters(value)
            "Inches" to "Feet" -> inchesToFeet(value)
            else -> value // No conversion needed
        }
    }

    // Weight conversion functions
    private fun weightUnitConversion(value: Double, fromUnit: String, toUnit: String): Double {
        return when (fromUnit to toUnit) {
            "Kilograms" to "Pounds" -> kilogramsToPounds(value)
            "Pounds" to "Kilograms" -> poundsToKilograms(value)
            else -> value // No conversion needed
        }
    }

    // Conversion functions for temperature
    private fun celsiusToFahrenheit(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }

    private fun celsiusToKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }

    private fun fahrenheitToKelvin(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9 + 273.15
    }

    private fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }

    private fun kelvinToFahrenheit(kelvin: Double): Double {
        return (kelvin - 273.15) * 9 / 5 + 32
    }

    // Conversion functions for length
    private fun metersToFeet(meters: Double): Double {
        return meters * 3.28084
    }

    private fun metersToInches(meters: Double): Double {
        return meters * 39.3701
    }

    private fun feetToMeters(feet: Double): Double {
        return feet / 3.28084
    }

    private fun feetToInches(feet: Double): Double {
        return feet * 12
    }

    private fun inchesToMeters(inches: Double): Double {
        return inches / 39.3701
    }

    private fun inchesToFeet(inches: Double): Double {
        return inches / 12
    }

    // Conversion functions for weight
    private fun kilogramsToPounds(kilograms: Double): Double {
        return kilograms * 2.20462
    }

    private fun poundsToKilograms(pounds: Double): Double {
        return pounds / 2.20462
    }
}
