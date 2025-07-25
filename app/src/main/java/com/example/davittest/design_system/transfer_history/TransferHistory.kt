package com.example.davittest.design_system.transfer_history

import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.example.davittest.presentation.extension.asCurrencyFormat

sealed class TransferHistory(val color: Color) {
   data class Positive(val text: String) : TransferHistory(color = Color.Green)

    data object Neutral : TransferHistory(Color.Black)
    data class Negative(val text: String) : TransferHistory(color = Color.Black)

    companion object {
        fun Double.fromMoney(): TransferHistory {
            return when {
                this > 0.0 -> Positive(text = this.asCurrencyFormat())
                this < 0.0 -> Negative(text = this.asCurrencyFormat())
                else -> Neutral

            }
        }
    }
}

fun TransferHistory.getColor(): Color {
    return when (this) {
        is TransferHistory.Negative -> this.color
        TransferHistory.Neutral -> this.color
        is TransferHistory.Positive -> this.color
    }
}


fun TransferHistory.geText(): String {
    return when (this) {
        is TransferHistory.Negative -> this.text
        TransferHistory.Neutral -> "0.0"
        is TransferHistory.Positive -> this.text
    }
}


