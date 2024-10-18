package com.sudoltyler.fetch.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sudoltyler.fetch.network.FetchApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

interface AppContainer {
    val fetchRepository : FetchRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://fetch-hiring.s3.amazonaws.com"

    private val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
            // time out setting
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(25,TimeUnit.SECONDS)

    }.build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .client(client)
        .build()

    private val retrofitService: FetchApiService by lazy {
        retrofit.create(FetchApiService::class.java)
    }

    override val fetchRepository: FetchRepository by lazy {
        NetworkFetchRepository(retrofitService)
    }
}