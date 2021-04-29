package com.didik.core.network

import com.didik.core.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Network {

    private const val BASE_URL = BuildConfig.API_BASE_URL

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private fun okHttpClient(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .pingInterval(30, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(createLoggingInterceptor())
        }
        return okHttpBuilder.build()
    }

    private fun createMoshiConverterFactory(): MoshiConverterFactory {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return MoshiConverterFactory.create(moshi)
    }

    fun builder(baseUrl: String = BASE_URL): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(createMoshiConverterFactory())
            .client(okHttpClient())
            .build()
    }
}