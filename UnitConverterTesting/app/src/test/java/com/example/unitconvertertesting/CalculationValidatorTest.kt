package com.example.unitconvertertesting

import org.junit.Assert.assertEquals
import org.junit.Test

class ConversionUtilsTest {

    // Temperature conversion tests
    @Test
    fun testCelsiusToFahrenheit() {
        val result = ConversionUtils.celsiusToFahrenheit(0.0)
        assertEquals(32.0, result, 0.001)
    }

    @Test
    fun testFahrenheitToCelsius() {
        val result = ConversionUtils.fahrenheitToCelsius(32.0)
        assertEquals(0.0, result, 0.001)
    }

    @Test
    fun testCelsiusToKelvin() {
        val result = ConversionUtils.celsiusToKelvin(0.0)
        assertEquals(273.15, result, 0.001)
    }

    @Test
    fun testKelvinToCelsius() {
        val result = ConversionUtils.kelvinToCelsius(273.15)
        assertEquals(0.0, result, 0.001)
    }

    // Length conversion tests
    @Test
    fun testMetersToFeet() {
        val result = ConversionUtils.metersToFeet(1.0)
        assertEquals(3.28084, result, 0.001)
    }

    @Test
    fun testFeetToMeters() {
        val result = ConversionUtils.feetToMeters(3.28084)
        assertEquals(1.0, result, 0.001)
    }

    // Weight conversion tests
    @Test
    fun testKilogramsToPounds() {
        val result = ConversionUtils.kilogramsToPounds(1.0)
        assertEquals(2.20462, result, 0.001)
    }

    @Test
    fun testPoundsToKilograms() {
        val result = ConversionUtils.poundsToKilograms(2.20462)
        assertEquals(1.0, result, 0.001)
    }
}
