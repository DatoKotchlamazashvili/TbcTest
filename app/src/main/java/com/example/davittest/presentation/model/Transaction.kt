package com.example.davittest.presentation.model

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.davittest.design_system.transfer_history.TransferHistory
import com.example.davittest.design_system.transfer_history.TransferHistory.Companion.fromMoney

data class Transaction(
    val date: String, val title: String, val amount: Double, val icon: ImageVector
)

fun Transaction.toPresentation(): TransactionUi = TransactionUi(
    date = this.date,
    title = this.title,
    transferHistory = this.amount.fromMoney(),
    icon = this.icon
)


data class TransactionUi(
    val date: String, val title: String, val transferHistory: TransferHistory, val icon: ImageVector
)

fun getTransaction():List<Transaction> = listOf(
    Transaction(      date = "8 May, 2025",
        title = "Private Transfer",
        amount = 211.0,
        icon = Icons.Default.MoreVert
    ),

    Transaction(      date = "8 May, 2025",
        title = "Private Transfer",
        amount = -61.0,
        icon = Icons.Default.ShoppingCart
    ),

    Transaction(      date = "8 May, 2025",
        title = "Private Transfer",
        amount = 0.0,
        icon = Icons.Default.Notifications
    ),

    )