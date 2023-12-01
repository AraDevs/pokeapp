package com.aradevs.pokeapp.network.di

import com.aradevs.pokeapp.network.BaseRequest
import com.aradevs.pokeapp.network.PokemonStatNameAdapter
import com.aradevs.pokeapp.network.PokemonStatSerializer
import com.aradevs.pokeapp.network.PokemonTypeNameAdapter
import com.aradevs.pokeapp.network.pokemon.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(ViewModelComponent::class)
class ApiModule {
    @Provides
    fun providesPokemonApi(): PokemonApi {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val moduleBaseUrl = PokemonApi.BASE_URL

        return BaseRequest<PokemonApi>(
            baseUrl = moduleBaseUrl,
            adapters = listOf(
                PokemonTypeNameAdapter,
                PokemonStatNameAdapter
            ),
            interceptors = listOf(
                loggingInterceptor,
            ),
        ).getService()
    }
}