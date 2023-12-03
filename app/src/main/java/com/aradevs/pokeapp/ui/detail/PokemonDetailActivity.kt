package com.aradevs.pokeapp.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aradevs.pokeapp.domain.Status
import com.aradevs.pokeapp.domain.pokemon.detail.PokemonDetail
import com.aradevs.pokeapp.domain.pokemon.detail.species.PokemonSpecies
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import com.aradevs.pokeapp.utils.POKEMON_ID
import com.aradevs.pokeapp.utils.POKEMON_NAME
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.StateFlow

@AndroidEntryPoint
class PokemonDetailActivity : ComponentActivity(), PokemonDetailActions {
    private val _viewModel: PokemonDetailActivityViewModel by viewModels()
    private var currentPokemonId: Int = 0
    private var currentPokemonName: String = ""

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentPokemonId = intent.getIntExtra(POKEMON_ID, 0)
        currentPokemonName = intent.getStringExtra(POKEMON_NAME) ?: ""

        if (currentPokemonId == 0 || currentPokemonName.isBlank()) {
            finish()
            return
        }

        _viewModel.apply {
            setCurrentPokemon(currentPokemonId, currentPokemonName)
            getPokemonDetail()
            getPokemonSpecies()
        }

        setContent {
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            PokeappTheme {
                Scaffold {
                    PokemonDetail(
                        modifier = Modifier.padding(
                            start = 15.dp,
                            end = 15.dp,
                            bottom = it.calculateBottomPadding(),
                            top = 15.dp
                        ),
                        windowSizeClass = windowSizeClass,
                        pokemonDetailActions = this@PokemonDetailActivity
                    )
                }
            }
        }
    }

    override fun getPokemonDetailStatus(): StateFlow<Status<PokemonDetail>> =
        _viewModel.pokemonDetail

    override fun getPokemonDetail() {
        _viewModel.getPokemonDetail()
    }

    override fun getPokemonSpeciesStatus(): StateFlow<Status<PokemonSpecies>> =
        _viewModel.pokemonSpecies

    override fun getPokemonSpecies() {
        _viewModel.getPokemonSpecies()
    }

    override fun getCurrentPokemon(): MutableState<Pokemon?> =
        _viewModel.currentPokemon

    override fun onBackButtonPressed() {
        finish()
    }
}