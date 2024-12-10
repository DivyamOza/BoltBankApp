package com.example.trainingapp.data.network

/**
 * Network UI state
 *
 * @param T
 * @constructor Create empty Network UI state
 */
sealed class NetworkUIState<T> {
    class LOADING<T> : NetworkUIState<T>()
    data class SUCCESS<T>(val data: T) : NetworkUIState<T>()
    data class ERROR<T>(val error: Any) : NetworkUIState<T>()
}