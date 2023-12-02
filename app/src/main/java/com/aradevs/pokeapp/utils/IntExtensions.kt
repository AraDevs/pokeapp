package com.aradevs.pokeapp.utils

fun Int.toTripeDigits(): String = when (this) {
    in 0..9 -> "00$this"
    in 10..99 -> "0$this"
    else -> this.toString()
}