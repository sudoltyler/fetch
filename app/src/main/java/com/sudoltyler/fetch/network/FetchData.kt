package com.sudoltyler.fetch.network

import kotlinx.serialization.Serializable

@Serializable
data class FetchData (
    val id: Long, val listId: Long, val name: String? = null
)