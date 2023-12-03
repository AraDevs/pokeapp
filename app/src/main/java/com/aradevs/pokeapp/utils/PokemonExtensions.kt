package com.aradevs.pokeapp.utils

import android.content.Context
import android.util.Log
import com.aradevs.pokeapp.R
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonStatName
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonTypeName
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpeciesFlavorTextEntry

const val MAX_POKEMON_EV = 255 //for first gen, according to https://bulbapedia.bulbagarden.net/wiki/Effort_values

fun PokemonTypeName.toStringResource(): Int =
    when (this) {
        PokemonTypeName.BUG -> R.string.type_bug
        PokemonTypeName.DARK -> R.string.type_dark
        PokemonTypeName.DRAGON -> R.string.type_dragon
        PokemonTypeName.ELECTRIC -> R.string.type_electric
        PokemonTypeName.FAIRY -> R.string.type_fairy
        PokemonTypeName.FIGHTING -> R.string.type_fighting
        PokemonTypeName.FIRE -> R.string.type_fire
        PokemonTypeName.FLYING -> R.string.type_flying
        PokemonTypeName.GHOST -> R.string.type_ghost
        PokemonTypeName.GRASS -> R.string.type_grass
        PokemonTypeName.GROUND -> R.string.type_ground
        PokemonTypeName.ICE -> R.string.type_ice
        PokemonTypeName.NORMAL -> R.string.type_normal
        PokemonTypeName.POISON -> R.string.type_poison
        PokemonTypeName.PSYCHIC -> R.string.type_psychic
        PokemonTypeName.ROCK -> R.string.type_rock
        PokemonTypeName.STEEL -> R.string.type_steel
        PokemonTypeName.WATER -> R.string.type_water
        PokemonTypeName.SHADOW -> R.string.type_shadow
        PokemonTypeName.UNKNOWN -> R.string.type_unknown
    }

fun PokemonStatName.toStringResource(): Int =
    when (this) {
        PokemonStatName.HP -> R.string.hp
        PokemonStatName.ATTACK -> R.string.attack
        PokemonStatName.DEFENSE -> R.string.defense
        PokemonStatName.SPECIAL_ATTACK -> R.string.special_attack
        PokemonStatName.SPECIAL_DEFENSE -> R.string.special_defense
        PokemonStatName.SPEED -> R.string.speed
        PokemonStatName.UNKNOWN -> R.string.type_unknown
    }

fun getPokemonWikiUrl(pokemonName: String): String =
    "https://pokemon.fandom.com/es/wiki/$pokemonName"

fun List<PokemonSpeciesFlavorTextEntry>.getEntryForCurrentLanguage(context: Context): String {
     val currentLanguage = context.resources.configuration.locales[0].language
    Log.e("getEntryForCurrentLanguage", "currentLanguage: $currentLanguage")

    return this.firstOrNull { it.language.name == currentLanguage }?.flavorText ?: "N/A"
}