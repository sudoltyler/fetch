package com.sudoltyler.fetch.data

import com.sudoltyler.fetch.network.FetchApiService
import com.sudoltyler.fetch.network.FetchData

interface FetchRepository {
    suspend fun getList(): List<FetchData>
}

class NetworkFetchRepository (
    private val fetchApiService: FetchApiService
) : FetchRepository {
    override suspend fun getList(): List<FetchData> = fetchApiService.getData()
}