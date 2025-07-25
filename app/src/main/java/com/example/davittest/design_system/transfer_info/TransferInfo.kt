package com.example.davittest.design_system.transfer_info

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.davittest.R

enum class TransferInfo {
    RECEIVE,SENT
}

fun TransferInfo.getIcon(): ImageVector {
    return when(this){
        TransferInfo.RECEIVE -> Icons.Default.KeyboardArrowDown
        TransferInfo.SENT -> Icons.Default.KeyboardArrowUp
    }
}

fun TransferInfo.getColor(): Color {
    return when(this){
        TransferInfo.RECEIVE -> Color.Green
        TransferInfo.SENT -> Color.Gray
    }
}

fun TransferInfo.getTextResourceId(): Int {
    return when(this){
        TransferInfo.RECEIVE -> R.string.receive
        TransferInfo.SENT -> R.string.send
    }
}