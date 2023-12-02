package com.aradevs.pokeapp.domain.pokemon.list

data class Pokemon(
    val id: Int = 0,
    val name: String,
    val image: String = "",
    val url: String
)

val mockPokemon: Pokemon = Pokemon(
    id = 1,
    name = "Bulbasaur",
    image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/1.png",
    url = "https://pokeapi.co/api/v2/pokemon/1/"
)
