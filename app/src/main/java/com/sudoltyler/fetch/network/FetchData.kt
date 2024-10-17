package com.sudoltyler.fetch.network

import kotlinx.serialization.Serializable

@Serializable
data class FetchData (
    val id: String, val listId: String, val name: String
)