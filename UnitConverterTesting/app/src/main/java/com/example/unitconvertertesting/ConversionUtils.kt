package com.example.unitconvertertesting

object ConversionUtils {

    // Conversion functions for temperature
    fun celsiusToFahrenheit(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }

    fun celsiusToKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }

    fun fahrenheitToKelvin(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9 + 273.15
    }

    fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }

    fun kelvinToFahrenheit(kelvin: Double): Double {
        return (kelvin - 273.15) * 9 / 5 + 32
    }

    // Conversion functions for length
    fun metersToFeet(meters: Double): Double {
        return meters * 3.28084
    }

    fun metersToInches(meters: Double): Double {
        return meters * 39.3701
    }

    fun feetToMeters(feet: Double): Double {
        return feet / 3.28084
    }

    fun feetToInches(feet: Double): Double {
        return feet * 12
    }

    fun inchesToMeters(inches: Double): Double {
        return inches / 39.3701
    }

    fun inchesToFeet(inches: Double): Double {
        return inches / 12
    }

    // Conversion functions for weight
    fun kilogramsToPounds(kilograms: Double): Double {
        return kilograms * 2.20462
    }

    fun poundsToKilograms(pounds: Double): Double {
        return pounds / 2.20462
    }
}
