package com.example.trainingapp.core

/**
 * Ui state
 *
 * @param T
 * @property data
 * @property message
 * @constructor Create empty Ui state
 */
sealed class UiState<T>(val data: T?, val message: String? = null) {
    class Success<T>(data: T?) : UiState<T>(data)
    class Loading<T>(data: T? = null) : UiState<T>(data)
    class Error<T>(data: T? = null, message: String?) : UiState<T>(data, message)
}