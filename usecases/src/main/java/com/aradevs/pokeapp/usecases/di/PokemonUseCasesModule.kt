package com.aradevs.pokeapp.usecases.di

import com.aradevs.pokeapp.data.repository.PokemonRepository
import com.aradevs.pokeapp.usecases.FetchPokemonUseCase
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
}