package com.example.davittest.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.davittest.analytics.AnalyticsProvider
import com.example.davittest.testing.DispatcherProvider

class ProfileViewModelFactory(
    private val dispatchers: DispatcherProvider,
    private val analyticsProvider: AnalyticsProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileScreenViewModel::class.java)) {
            return ProfileScreenViewModel(dispatchers, analyticsProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
