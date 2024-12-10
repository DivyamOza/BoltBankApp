package com.example.trainingapp.utils

/**
 * Validation utils
 *
 * @constructor Create empty Validation utils
 */
object ValidationUtils {

    /**
     * Validate phone number
     *
     * @param number
     * @return
     */
    fun validatePhoneNumber(number: String): String? {
        return when {
            number.isEmpty() -> "Phone number is required"
            number.length != 10 -> "Phone number must be 10 digits"
            !number.all { it.isDigit() } -> "Phone number must contain only digits"
            else -> null
        }
    }

    fun validatePassword(pass: String): String? {
        return when {
            pass.isEmpty() -> "Password is required"
            pass.length < 8 -> "Password must be at least 8 characters"
            !pass.any { it.isDigit() } -> "Password must contain at least one digit"
            !pass.any { it.isSpecialChar() } -> "Password must contain at least one special character"
            else -> null
        }
    }

    private fun Char.isSpecialChar(): Boolean {
        return this in "!@#$%^&*()_+-=[]{}|;:'\",.<>?/`~"
    }
}