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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.davittest.analytics.PosthogAnalyticsHelper
import com.example.davittest.presentation.screen.ProfileScreen
import com.example.davittest.presentation.screen.ProfileScreenViewModel
import com.example.davittest.presentation.screen.ProfileViewModelFactory
import com.example.davittest.testing.StandardDispatchers
import com.example.davittest.ui.theme.DavitTestTheme
import com.posthog.internal.PostHogLogger

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val app = application as App //hide this line of code

        setContent {
            DavitTestTheme {
                val snackBarHostState = remember { SnackbarHostState() }

                val viewModel: ProfileScreenViewModel = viewModel(
                    factory = ProfileViewModelFactory(
                        dispatchers = StandardDispatchers,
                        analyticsProvider = app.analyticsProvider
                    )
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackBarHostState) }
                ) { innerPadding ->
                    ProfileScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(20.dp),
                        viewModel = viewModel,
                        snackbarHostState = snackBarHostState
                    )
                }
            }
        }
    }
}