package com.example.tingle.model

data class Match(
    val id: String,
    val user: User,
    val lastMessage: String,
    val timestamp: String,
    val unreadCount: Int = 0
)
