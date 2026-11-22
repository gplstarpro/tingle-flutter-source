package com.example.tingle.model

data class User(
    val id: String,
    val name: String,
    val age: Int,
    val bio: String,
    val imageUrls: List<String>,
    val location: String,
    val distance: String,
    val interests: List<String>,
    val verified: Boolean = false
)
