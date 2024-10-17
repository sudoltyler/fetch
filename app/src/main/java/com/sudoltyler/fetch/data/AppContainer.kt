package com.sudoltyler.fetch.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sudoltyler.fetch.network.FetchApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

interface AppContainer {
    val fetchRepository : FetchRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://fetch-hiring.s3.amazonaws.com/hiring.json"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: FetchApiService by lazy {
        retrofit.create(FetchApiService::class.java)
    }

    override val fetchRepository: FetchRepository by lazy {
        NetworkFetchRepository(retrofitService)
    }
}