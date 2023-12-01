package com.aradevs.pokeapp.network.di

import com.aradevs.pokeapp.data.data_source.PokemonRemoteDataSource
import com.aradevs.pokeapp.network.pokemon.PokemonApi
import com.aradevs.pokeapp.network.pokemon.PokemonRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RemoteDataSourceModule {
    @Provides
    fun providesPokemonRemoteDataSourceImpl(api: PokemonApi): PokemonRemoteDataSource {
        return PokemonRemoteDataSourceImpl(api)
    }
}