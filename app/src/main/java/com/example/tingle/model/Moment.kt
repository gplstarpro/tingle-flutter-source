package com.example.tingle.model

data class Moment(
    val id: String,
    val authorName: String,
    val authorImageUrl: String,
    val content: String,
    val imageUrl: String? = null,
    val likesCount: Int,
    val commentsCount: Int,
    val timeAgo: String
)
