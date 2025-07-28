package com.example.davittest.presentation.screen

import androidx.compose.runtime.Stable
import com.example.davittest.presentation.components.Profile
import com.example.davittest.presentation.model.Account
import com.example.davittest.presentation.model.TransactionUi
import com.example.davittest.presentation.model.getAccount
import com.example.davittest.presentation.model.getTransaction
import com.example.davittest.presentation.model.toPresentation

@Stable
data class ProfileUiState(
    val profile: Profile = Profile(
        img = "sdjkfhsdfjk", name = "Khatia Gogua", job = "Mom"
    ),
    val transactions: List<TransactionUi> = getTransaction().map { it.toPresentation() },
    val accounts: List<Account> = getAccount(),
    val selectedStartDate: Long = System.currentTimeMillis(),
    val selectedEndDate:Long = System.currentTimeMillis(),
    val showMore: Boolean = false
)