package com.aradevs.pokeapp.network

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object PokemonStatNameAdapter {
    @ToJson
    @Synchronized
    fun statToJson(statName: PokemonStatNameSerializer): String = when (statName) {
        PokemonStatNameSerializer.HP -> "hp"
        PokemonStatNameSerializer.ATTACK -> "attack"
        PokemonStatNameSerializer.DEFENSE -> "defense"
        PokemonStatNameSerializer.SPECIAL_ATTACK -> "special-attack"
        PokemonStatNameSerializer.SPECIAL_DEFENSE -> "special-defense"
        PokemonStatNameSerializer.SPEED -> "speed"
        PokemonStatNameSerializer.UNKNOWN -> "unknown"
    }

    @FromJson
    @Synchronized
    fun statFromJson(statName: String): PokemonStatNameSerializer = when (statName) {
        "hp" -> PokemonStatNameSerializer.HP
        "attack" -> PokemonStatNameSerializer.ATTACK
        "defense" -> PokemonStatNameSerializer.DEFENSE
        "special-attack" -> PokemonStatNameSerializer.SPECIAL_ATTACK
        "special-defense" -> PokemonStatNameSerializer.SPECIAL_DEFENSE
        "speed" -> PokemonStatNameSerializer.SPEED
        else -> PokemonStatNameSerializer.UNKNOWN
    }
}

object PokemonTypeNameAdapter {
    @ToJson
    @Synchronized
    fun typeToJson(typeName: PokemonTypeNameSerializer): String = when (typeName) {
        PokemonTypeNameSerializer.NORMAL -> "normal"
        PokemonTypeNameSerializer.FIGHTING -> "fighting"
        PokemonTypeNameSerializer.FLYING -> "flying"
        PokemonTypeNameSerializer.POISON -> "poison"
        PokemonTypeNameSerializer.GROUND -> "ground"
        PokemonTypeNameSerializer.ROCK -> "rock"
        PokemonTypeNameSerializer.BUG -> "bug"
        PokemonTypeNameSerializer.GHOST -> "ghost"
        PokemonTypeNameSerializer.STEEL -> "steel"
        PokemonTypeNameSerializer.FIRE -> "fire"
        PokemonTypeNameSerializer.WATER -> "water"
        PokemonTypeNameSerializer.GRASS -> "grass"
        PokemonTypeNameSerializer.ELECTRIC -> "electric"
        PokemonTypeNameSerializer.PSYCHIC -> "psychic"
        PokemonTypeNameSerializer.ICE -> "ice"
        PokemonTypeNameSerializer.DRAGON -> "dragon"
        PokemonTypeNameSerializer.DARK -> "dark"
        PokemonTypeNameSerializer.FAIRY -> "fairy"
        PokemonTypeNameSerializer.UNKNOWN -> "unknown"
        PokemonTypeNameSerializer.SHADOW -> "shadow"
    }

    @FromJson
    @Synchronized
    fun typeFromJson(typeName: String): PokemonTypeNameSerializer = when (typeName) {
        "normal" -> PokemonTypeNameSerializer.NORMAL
        "fighting" -> PokemonTypeNameSerializer.FIGHTING
        "flying" -> PokemonTypeNameSerializer.FLYING
        "poison" -> PokemonTypeNameSerializer.POISON
        "ground" -> PokemonTypeNameSerializer.GROUND
        "rock" -> PokemonTypeNameSerializer.ROCK
        "bug" -> PokemonTypeNameSerializer.BUG
        "ghost" -> PokemonTypeNameSerializer.GHOST
        "steel" -> PokemonTypeNameSerializer.STEEL
        "fire" -> PokemonTypeNameSerializer.FIRE
        "water" -> PokemonTypeNameSerializer.WATER
        "grass" -> PokemonTypeNameSerializer.GRASS
        "electric" -> PokemonTypeNameSerializer.ELECTRIC
        "psychic" -> PokemonTypeNameSerializer.PSYCHIC
        "ice" -> PokemonTypeNameSerializer.ICE
        "dragon" -> PokemonTypeNameSerializer.DRAGON
        "dark" -> PokemonTypeNameSerializer.DARK
        "fairy" -> PokemonTypeNameSerializer.FAIRY
        "unknown" -> PokemonTypeNameSerializer.UNKNOWN
        "shadow" -> PokemonTypeNameSerializer.SHADOW
        else -> PokemonTypeNameSerializer.UNKNOWN
    }
}

