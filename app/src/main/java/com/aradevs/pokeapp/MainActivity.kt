package com.aradevs.pokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.aradevs.pokeapp.domain.pokemon.list.Pokemon
import com.aradevs.pokeapp.ui.home.HomeScreen
import com.aradevs.pokeapp.ui.theme.PokeappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), PokemonActions {
    private val _viewModel: MainActivityViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            PokeappTheme {
                Scaffold {
                    HomeScreen(
                        modifier = Modifier.padding(
                            start = 15.dp,
                            end = 15.dp,
                            bottom = it.calculateBottomPadding(),
                            top = 15.dp
                        ),
                        windowSizeClass = windowSizeClass,
                        pokemonActions = this@MainActivity
                    )
                }
            }
        }
    }

    @Composable
    override fun getPokemonList(): LazyPagingItems<Pokemon> =
        _viewModel.pokemonList.collectAsLazyPagingItems()

    override fun getCurrentPokemonDetail() = _viewModel.currentPokemonDetail

    override fun getPokemonDetail(identifier: String) {
        _viewModel.getPokemonDetail(identifier)
    }

    override fun getFilterValue(): MutableState<String> = _viewModel.currentFilterValue

    override fun updateFilterValue(newValue: String) {
        _viewModel.updateFilterValue(newValue)
    }
}
