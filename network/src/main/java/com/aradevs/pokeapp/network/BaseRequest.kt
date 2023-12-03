package com.aradevs.pokeapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/*
* BaseRequest.kt
 */
class BaseRequest<T : Any>(
    private val baseUrl: String,
    private val adapters: List<Any>,
    private val interceptors: List<Interceptor>,
    private val authenticator: Authenticator? = null,
) {

    private val moshi: Moshi = Moshi.Builder().run {
        adapters.forEach { adapter ->
            add(adapter)
        }
        add(KotlinJsonAdapterFactory())
        build()
    }

    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder().apply {
        callTimeout(90, TimeUnit.SECONDS)
        if (authenticator != null) {
            this.authenticator(authenticator)
        }
        interceptors.forEach { interceptor ->
            this.addInterceptor(interceptor)
        }
    }.build()

    inline fun <reified T : Any> getService(): T =
        buildRetrofit().run {
            create(T::class.java)
        }

    fun buildRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi).withNullSerialization())
        .build()
}