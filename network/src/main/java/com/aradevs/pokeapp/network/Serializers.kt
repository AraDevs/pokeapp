package com.aradevs.pokeapp.network

import com.squareup.moshi.Json

data class PokemonListSerializer(
    val next: String?,
    val previous: String?,
    val results: List<PokemonSerializer>?
)

data class PokemonSerializer(
    val name: String?,
    val url: String?
)

//region Pokemon Detail

enum class PokemonStatNameSerializer {
    HP,
    ATTACK,
    DEFENSE,
    SPECIAL_ATTACK,
    SPECIAL_DEFENSE,
    SPEED,
    UNKNOWN,
}

enum class PokemonTypeNameSerializer {
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY,
    UNKNOWN,
    SHADOW,
}

data class PokemonDetailSerializer(
    val id: String?,
    val name: String?,
    val height: Int?, //decimeters
    val weight: Int?, //hectograms
    val stats: List<PokemonStatSerializer>?,
    val types: List<PokemonTypeSerializer>?
)

data class PokemonStatSerializer(
    @Json(name = "base_stat")
    val baseStat: Int?,
    val effort: Int?,
    val stat: PokemonStatDetailSerializer,
)

data class PokemonStatDetailSerializer(
    val name: PokemonStatNameSerializer,
)

data class PokemonTypeSerializer(
    val slot: Int?,
    val type: PokemonTypeDetailSerializer
)

data class PokemonTypeDetailSerializer(
    val name: PokemonTypeNameSerializer,
)

//endregion

//region Pokemon Species
data class PokemonSpeciesTextLanguageSerializer(
    val name: String?,
)

data class PokemonSpeciesFlavorTextEntrySerializer(
    @Json(name = "flavor_text")
    val flavorText: String?,
    val language: PokemonSpeciesTextLanguageSerializer,
)

data class PokemonSpeciesSerializer(
    val id: String?,
    @Json(name = "flavor_text_entries")
    val flavorTextEntries: List<PokemonSpeciesFlavorTextEntrySerializer>?,
)
//endregion


