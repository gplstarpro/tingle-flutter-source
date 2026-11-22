package com.example.tingle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tingle.ui.screens.MainHomeScreen
import com.example.tingle.ui.theme.TingleTheme
import com.example.tingle.viewmodel.TingleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TingleTheme {
                val viewModel: TingleViewModel = viewModel()
                MainHomeScreen(viewModel = viewModel)
            }
        }
    }
}
