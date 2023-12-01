package com.aradevs.pokeapp.usecases.di

import com.aradevs.pokeapp.data.repository.PokemonRepository
import com.aradevs.pokeapp.usecases.FetchPokemonUseCase
import com.aradevs.pokeapp.usecases.GetPokemonDetailUseCase
import com.aradevs.pokeapp.usecases.GetPokemonSpeciesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PokemonUseCasesModule {
    @Provides
    fun providesGetPokemonListUseCase(repository: PokemonRepository) =
        FetchPokemonUseCase(repository)

    @Provides
    fun providesGetPokemonDetailUseCase(repository: PokemonRepository) =
        GetPokemonDetailUseCase(repository)

    @Provides
    fun providesGetPokemonSpeciesUseCase(repository: PokemonRepository) =
        GetPokemonSpeciesUseCase(repository)
}