package com.example.davittest.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.davittest.design_system.MenuItem
import java.util.UUID

data class Account(
    val id: String = UUID.randomUUID().toString(),
    val mainText: String,
    val subText: String,
    val iconStart: ImageVector,
    val iconEnd: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight
)

fun getAccount(): List<Account> = listOf(
    Account(
        iconStart = Icons.Default.Phone,
        mainText = "Mobile Number",
        subText = "591 16 72 23",

        ),
    Account(
        iconStart = Icons.Default.Face,
        mainText = "Tbc Card",
        subText = "GE8**FHWQH***",
    ),
    Account(
        iconStart = Icons.Default.LocationOn,
        mainText = "Georgian Bank",
        subText = "AV8**FHWQH***",
    )
)