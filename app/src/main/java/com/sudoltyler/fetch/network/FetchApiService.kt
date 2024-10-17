package com.sudoltyler.fetch.network

import retrofit2.http.GET

interface FetchApiService {
    @GET("data")
    suspend fun getData(): List<FetchData>
}