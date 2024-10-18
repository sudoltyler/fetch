package com.sudoltyler.fetch.network

import retrofit2.http.GET

interface FetchApiService {
    @GET("hiring")
    suspend fun getData(): List<FetchData>
}