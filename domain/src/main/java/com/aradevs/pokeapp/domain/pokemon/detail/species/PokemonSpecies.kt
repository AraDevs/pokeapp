package com.aradevs.pokeapp.domain.pokemon.detail.species

data class PokemonSpecies(
    val id: String,
    val flavorTextEntries: List<PokemonSpeciesFlavorTextEntry>,
)

/**
 * Mocked PokemonSpecies
 */
val mockPokemonSpecies = PokemonSpecies(
    id = "1",
    flavorTextEntries = listOf(
        PokemonSpeciesFlavorTextEntry(
            flavorText = "It was created by\na scientist after\nyears of horrific gene splicing and\nDNA engineering\nexperiments.",
            language = PokemonSpeciesTextLanguage(
                name = "en",
            ),
        ),
        PokemonSpeciesFlavorTextEntry(
            flavorText = "A Pokémon created\nby recombining\nMEW's genes. It's\nsaid to have the\nmost savage heart\namong Pokémon.",
            language = PokemonSpeciesTextLanguage(
                name = "en",
            ),
        ),
        PokemonSpeciesFlavorTextEntry(
            flavorText = "Spettro di Mewtwo",
            language = PokemonSpeciesTextLanguage(
                name = "it",
            ),
        ),
        PokemonSpeciesFlavorTextEntry(
            flavorText = "Un Pokémon creato\ncombinando i geni\ndi MEW. Si dice\nche abbia il cuore\npiù crudele tra\ntutti i Pokémon.",
            language = PokemonSpeciesTextLanguage(
                name = "it",
            ),
        ),
    )
)