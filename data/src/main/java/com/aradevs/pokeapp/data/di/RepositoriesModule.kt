package com.aradevs.pokeapp.data.di

import com.aradevs.pokeapp.data.data_source.PokemonRemoteDataSource
import com.aradevs.pokeapp.data.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoriesModule {
    @Provides
    fun providesPokemonRepository(
        pokemonRemoteDataSource: PokemonRemoteDataSource
    ): PokemonRepository = PokemonRepository(pokemonRemoteDataSource)
}