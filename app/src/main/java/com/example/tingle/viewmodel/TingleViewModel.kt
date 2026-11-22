package com.example.tingle.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tingle.data.MockDataSource
import com.example.tingle.model.LiveRoom
import com.example.tingle.model.Match
import com.example.tingle.model.Message
import com.example.tingle.model.Moment
import com.example.tingle.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TingleViewModel : ViewModel() {
    private val _discoverUsers = MutableStateFlow(MockDataSource.discoverUsers)
    val discoverUsers: StateFlow<List<User>> = _discoverUsers.asStateFlow()

    private val _matches = MutableStateFlow(MockDataSource.matches)
    val matches: StateFlow<List<Match>> = _matches.asStateFlow()

    private val _messages = MutableStateFlow(MockDataSource.sampleMessages)
    val messages: StateFlow<Map<String, List<Message>>> = _messages.asStateFlow()

    private val _liveRooms = MutableStateFlow(MockDataSource.liveRooms)
    val liveRooms: StateFlow<List<LiveRoom>> = _liveRooms.asStateFlow()

    private val _moments = MutableStateFlow(MockDataSource.moments)
    val moments: StateFlow<List<Moment>> = _moments.asStateFlow()

    private val _likedMatchUser = MutableStateFlow<User?>(null)
    val likedMatchUser: StateFlow<User?> = _likedMatchUser.asStateFlow()

    fun onSwipeUser(user: User, isLike: Boolean) {
        _discoverUsers.update { current -> current.drop(1) }
        if (isLike) {
            // Trigger match simulation for demo
            if (user.id == "1" || user.id == "3") {
                _likedMatchUser.value = user
                val newMatch = Match(
                    id = "m_${System.currentTimeMillis()}",
                    user = user,
                    lastMessage = "You matched with ${user.name}!",
                    timestamp = "Just now",
                    unreadCount = 1
                )
                _matches.update { listOf(newMatch) + it }
            }
        }
    }

    fun dismissMatchPopup() {
        _likedMatchUser.value = null
    }

    fun sendMessage(matchId: String, text: String) {
        if (text.isBlank()) return
        val newMsg = Message(
            id = "msg_${System.currentTimeMillis()}",
            senderId = "me",
            text = text,
            timestamp = "Just now"
        )
        _messages.update { currentMap ->
            val list = currentMap[matchId] ?: emptyList()
            currentMap + (matchId to (list + newMsg))
        }
        // Update last message in matches
        _matches.update { list ->
            list.map { match ->
                if (match.id == matchId) {
                    match.copy(lastMessage = text, timestamp = "Just now")
                } else match
            }
        }
    }

    fun addMoment(content: String, imageUrl: String? = null) {
        if (content.isBlank()) return
        val newMoment = Moment(
            id = "mo_${System.currentTimeMillis()}",
            authorName = "You",
            authorImageUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?auto=format&fit=crop&w=800&q=80",
            content = content,
            imageUrl = imageUrl,
            likesCount = 0,
            commentsCount = 0,
            timeAgo = "Just now"
        )
        _moments.update { listOf(newMoment) + it }
    }
}
