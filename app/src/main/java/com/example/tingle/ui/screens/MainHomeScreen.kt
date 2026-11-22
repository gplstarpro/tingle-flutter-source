package com.example.tingle.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tingle.model.LiveRoom
import com.example.tingle.model.Match
import com.example.tingle.viewmodel.TingleViewModel

@Composable
fun MainHomeScreen(viewModel: TingleViewModel) {
    var selectedTab by remember { mutableIntStateOf(0) }
    var activeChatMatch by remember { mutableStateOf<Match?>(null) }
    var activeLiveRoom by remember { mutableStateOf<LiveRoom?>(null) }

    val likedMatchUser by viewModel.likedMatchUser.collectAsState()

    val tabs = listOf("Discover", "Matches", "Live", "Moments", "Profile")

    if (activeLiveRoom != null) {
        LiveRoomDetailScreen(
            room = activeLiveRoom!!,
            onLeave = { activeLiveRoom = null }
        )
    } else if (activeChatMatch != null) {
        ChatScreen(
            match = activeChatMatch!!,
            viewModel = viewModel,
            onBack = { activeChatMatch = null }
        )
    } else {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Favorite, contentDescription = "Discover") },
                        label = { Text("Discover") },
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Chat, contentDescription = "Matches") },
                        label = { Text("Matches") },
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.LiveTv, contentDescription = "Live") },
                        label = { Text("Live") },
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.PhotoLibrary, contentDescription = "Moments") },
                        label = { Text("Moments") },
                        selected = selectedTab == 3,
                        onClick = { selectedTab = 3 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = selectedTab == 4,
                        onClick = { selectedTab = 4 }
                    )
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                when (selectedTab) {
                    0 -> DiscoverScreen(viewModel)
                    1 -> MatchesScreen(viewModel, onOpenChat = { match -> activeChatMatch = match })
                    2 -> LiveRoomsScreen(viewModel, onJoinRoom = { room -> activeLiveRoom = room })
                    3 -> MomentsScreen(viewModel)
                    4 -> ProfileScreen(viewModel)
                }
            }
        }
    }

    // Match Celebration Dialog
    if (likedMatchUser != null) {
        AlertDialog(
            onDismissRequest = { viewModel.dismissMatchPopup() },
            title = {
                Text(
                    text = "It's a Match! 🎉",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "You and ${likedMatchUser?.name} liked each other.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    AsyncImage(
                        model = likedMatchUser?.imageUrls?.first(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                }
            },
            confirmButton = {
                Button(onClick = { viewModel.dismissMatchPopup() }) {
                    Text("Send Message")
                }
            },
            dismissButton = {
                TextButton(onClick = { viewModel.dismissMatchPopup() }) {
                    Text("Keep Swiping")
                }
            }
        )
    }
}
