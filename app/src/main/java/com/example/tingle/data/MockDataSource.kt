package com.example.tingle.data

import com.example.tingle.model.LiveRoom
import com.example.tingle.model.Match
import com.example.tingle.model.Message
import com.example.tingle.model.Moment
import com.example.tingle.model.User

object MockDataSource {
    val discoverUsers = listOf(
        User(
            id = "1",
            name = "Sophia",
            age = 24,
            bio = "Coffee lover, art enthusiast, and weekend hiker. Looking for someone to explore new cafes with! ☕🎨",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1494790108377-be9c29b29330?auto=format&fit=crop&w=800&q=80",
                "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=800&q=80"
            ),
            location = "New York, NY",
            distance = "2 miles away",
            interests = listOf("Coffee", "Art", "Hiking", "Photography"),
            verified = true
        ),
        User(
            id = "2",
            name = "Liam",
            age = 27,
            bio = "Software engineer by day, indie musician by night. Let's talk about sci-fi and vinyl records.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?auto=format&fit=crop&w=800&q=80"
            ),
            location = "Brooklyn, NY",
            distance = "4 miles away",
            interests = listOf("Music", "Coding", "Sci-Fi", "Vinyl"),
            verified = true
        ),
        User(
            id = "3",
            name = "Chloe",
            age = 23,
            bio = "Yoga instructor and plant mom 🌿. Always down for sunset picnics and indie pop music.",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=800&q=80"
            ),
            location = "Manhattan, NY",
            distance = "1 mile away",
            interests = listOf("Yoga", "Plants", "Picnics", "Music")
        ),
        User(
            id = "4",
            name = "Noah",
            age = 26,
            bio = "Foodie, traveler, and amateur chef. Can you beat my pasta recipe?",
            imageUrls = listOf(
                "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?auto=format&fit=crop&w=800&q=80"
            ),
            location = "Queens, NY",
            distance = "5 miles away",
            interests = listOf("Cooking", "Travel", "Foodie", "Fitness")
        )
    )

    val matches = listOf(
        Match(
            id = "m1",
            user = discoverUsers[0],
            lastMessage = "Hey! That cafe looks amazing.",
            timestamp = "10:45 AM",
            unreadCount = 2
        ),
        Match(
            id = "m2",
            user = discoverUsers[1],
            lastMessage = "What's your favorite vinyl record?",
            timestamp = "Yesterday",
            unreadCount = 0
        )
    )

    val sampleMessages = mapOf(
        "m1" to listOf(
            Message("msg1", "1", "Hey there! How is your day going?", "10:30 AM"),
            Message("msg2", "me", "Pretty good! Just working on some Android apps.", "10:40 AM"),
            Message("msg3", "1", "Hey! That cafe looks amazing.", "10:45 AM")
        ),
        "m2" to listOf(
            Message("msg4", "2", "Hi! Thanks for the match.", "Yesterday"),
            Message("msg5", "me", "Hey Liam! Loving your music taste.", "Yesterday"),
            Message("msg6", "2", "What's your favorite vinyl record?", "Yesterday")
        )
    )

    val liveRooms = listOf(
        LiveRoom(
            id = "l1",
            hostName = "Jessica Live",
            hostImageUrl = "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=800&q=80",
            title = "Late Night Acoustic Jam & Chill 🎶",
            viewersCount = 1240,
            category = "Music"
        ),
        LiveRoom(
            id = "l2",
            hostName = "Alex Talks",
            hostImageUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?auto=format&fit=crop&w=800&q=80",
            title = "Travel Stories & Q&A 🌍",
            viewersCount = 850,
            category = "Travel"
        ),
        LiveRoom(
            id = "l3",
            hostName = "Mia Fitness",
            hostImageUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=800&q=80",
            title = "Home Workout & Healthy Smoothie Prep 🥗",
            viewersCount = 2100,
            category = "Lifestyle"
        )
    )

    val moments = listOf(
        Moment(
            id = "mo1",
            authorName = "Sophia",
            authorImageUrl = "https://images.unsplash.com/photo-1494790108377-be9c29b29330?auto=format&fit=crop&w=800&q=80",
            content = "Found this hidden gem in the city! Best iced matcha latte ever. 🍵✨",
            imageUrl = "https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=800&q=80",
            likesCount = 48,
            commentsCount = 6,
            timeAgo = "2 hours ago"
        ),
        Moment(
            id = "mo2",
            authorName = "Noah",
            authorImageUrl = "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?auto=format&fit=crop&w=800&q=80",
            content = "Sunset hike was totally worth the steep climb. Nature recharges the soul.",
            imageUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?auto=format&fit=crop&w=800&q=80",
            likesCount = 92,
            commentsCount = 14,
            timeAgo = "5 hours ago"
        )
    )
}
