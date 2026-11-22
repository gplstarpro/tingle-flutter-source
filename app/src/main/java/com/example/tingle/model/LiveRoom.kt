package com.example.tingle.model

data class LiveRoom(
    val id: String,
    val hostName: String,
    val hostImageUrl: String,
    val title: String,
    val viewersCount: Int,
    val category: String
)
