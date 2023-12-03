package com.aradevs.pokeapp.network

import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.domain.pokemon.list.PokemonList
import com.aradevs.pokeapp.domain.capitalized
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonStat
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonStatDetail
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonStatName
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonType
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonTypeDetail
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonTypeName
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpecies
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpeciesFlavorTextEntry
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpeciesTextLanguage
import com.aradevs.safe.safeInt
import com.aradevs.safe.safeList
import com.aradevs.safe.safeString

fun PokemonSerializer.toDomain(): Pokemon =
    Pokemon(
        name = name.safeString().capitalized(),
        url = url.safeString()
    )

fun PokemonListSerializer.toDomain(): PokemonList =
    PokemonList(
        next = next.safeString(),
        previous = previous.safeString(),
        results = results?.map { it.toDomain() }.safeList()
    )

//region PokemonDetail

fun PokemonStatNameSerializer.toDomain(): PokemonStatName =
    when (this) {
        PokemonStatNameSerializer.HP -> PokemonStatName.HP
        PokemonStatNameSerializer.ATTACK -> PokemonStatName.ATTACK
        PokemonStatNameSerializer.DEFENSE -> PokemonStatName.DEFENSE
        PokemonStatNameSerializer.SPECIAL_ATTACK -> PokemonStatName.SPECIAL_ATTACK
        PokemonStatNameSerializer.SPECIAL_DEFENSE -> PokemonStatName.SPECIAL_DEFENSE
        PokemonStatNameSerializer.SPEED -> PokemonStatName.SPEED
        else -> PokemonStatName.UNKNOWN
    }

fun PokemonStatDetailSerializer.toDomain(): PokemonStatDetail =
    PokemonStatDetail(
        name = name.toDomain()
    )

fun PokemonTypeNameSerializer.toDomain(): PokemonTypeName =
    when (this) {
        PokemonTypeNameSerializer.NORMAL -> PokemonTypeName.NORMAL
        PokemonTypeNameSerializer.FIGHTING -> PokemonTypeName.FIGHTING
        PokemonTypeNameSerializer.FLYING -> PokemonTypeName.FLYING
        PokemonTypeNameSerializer.POISON -> PokemonTypeName.POISON
        PokemonTypeNameSerializer.GROUND -> PokemonTypeName.GROUND
        PokemonTypeNameSerializer.ROCK -> PokemonTypeName.ROCK
        PokemonTypeNameSerializer.BUG -> PokemonTypeName.BUG
        PokemonTypeNameSerializer.GHOST -> PokemonTypeName.GHOST
        PokemonTypeNameSerializer.STEEL -> PokemonTypeName.STEEL
        PokemonTypeNameSerializer.FIRE -> PokemonTypeName.FIRE
        PokemonTypeNameSerializer.WATER -> PokemonTypeName.WATER
        PokemonTypeNameSerializer.GRASS -> PokemonTypeName.GRASS
        PokemonTypeNameSerializer.ELECTRIC -> PokemonTypeName.ELECTRIC
        PokemonTypeNameSerializer.PSYCHIC -> PokemonTypeName.PSYCHIC
        PokemonTypeNameSerializer.ICE -> PokemonTypeName.ICE
        PokemonTypeNameSerializer.DRAGON -> PokemonTypeName.DRAGON
        PokemonTypeNameSerializer.DARK -> PokemonTypeName.DARK
        PokemonTypeNameSerializer.FAIRY -> PokemonTypeName.FAIRY
        PokemonTypeNameSerializer.UNKNOWN -> PokemonTypeName.UNKNOWN
        PokemonTypeNameSerializer.SHADOW -> PokemonTypeName.SHADOW
    }

fun PokemonTypeDetailSerializer.toDomain(): PokemonTypeDetail =
    PokemonTypeDetail(
        name = name.toDomain()
    )

fun PokemonTypeSerializer.toDomain(): PokemonType =
    PokemonType(
        slot = slot.safeInt(),
        type = type.toDomain()
    )


fun PokemonStatSerializer.toDomain(): PokemonStat =
    PokemonStat(
        baseStat = baseStat.safeInt(),
        effort = effort.safeInt(),
        stat = stat.toDomain()
    )

fun PokemonDetailSerializer.toDomain(): PokemonDetail =
    PokemonDetail(
        id = id.safeString(),
        name = name.safeString().capitalized(),
        height = height.safeInt(),
        weight = weight.safeInt(),
        stats = stats?.map { it.toDomain() }.safeList(),
        types = types?.sortedBy { it.slot }?.map { it.toDomain() }.safeList()
    )

//endregion

//region Pokemon Species

fun PokemonSpeciesTextLanguageSerializer.toDomain(): PokemonSpeciesTextLanguage =
    PokemonSpeciesTextLanguage(
        name = name.safeString()
    )

fun PokemonSpeciesFlavorTextEntrySerializer.toDomain(): PokemonSpeciesFlavorTextEntry =
    PokemonSpeciesFlavorTextEntry(
        flavorText = flavorText?.replace("\n", "").safeString(),
        language = language.toDomain(),
    )

fun PokemonSpeciesSerializer.toDomain(): PokemonSpecies =
    PokemonSpecies(
        id = id.safeString(),
        flavorTextEntries = flavorTextEntries?.map { it.toDomain() }.safeList(),
    )
//endregion