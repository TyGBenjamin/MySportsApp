package com.example.mysportsapp.utils

/**
 * Resource for handling data or error regarding api Request.
 *
 * @param T
 * @constructor Create empty Resource
 */
sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    object Idle : Resource<Nothing>()
    object Loading : Resource<Nothing>()
    data class Error(val errorMessage: String) : Resource<Nothing>()
}
