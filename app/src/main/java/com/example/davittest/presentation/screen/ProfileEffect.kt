package com.example.davittest.presentation.screen

import android.os.Message

sealed interface ProfileEffect {
    data class OnError(val message: String): ProfileEffect

    data object OnNavigateBack: ProfileEffect
    data object OnNavigateToAddNewAccount: ProfileEffect
    data class OnNavigateToAccount(val id: String): ProfileEffect

}