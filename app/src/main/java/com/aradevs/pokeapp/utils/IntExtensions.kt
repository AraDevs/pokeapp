package com.aradevs.pokeapp.utils

/**
 * Extension function to convert an [Int] to a triple digits [String]
 */
fun Int.toTripeDigits(): String = when (this) {
    in 0..9 -> "00$this"
    in 10..99 -> "0$this"
    else -> this.toString()
}

fun Int.decimeterToMeters(): Double = this.toDouble() / 10

fun Int.hectogramsToKilograms(): Double = this.toDouble() / 10