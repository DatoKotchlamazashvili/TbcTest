package com.example.davittest

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.davittest.presentation.screen.ProfileScreenContent
import com.example.davittest.presentation.screen.ProfileUiState
import com.example.davittest.ui.theme.DavitTestTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DavitTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreenContent(
                        uiState = ProfileUiState(),
                        onAction = { },
                        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(20.dp))
                }
            }
        }
    }}
