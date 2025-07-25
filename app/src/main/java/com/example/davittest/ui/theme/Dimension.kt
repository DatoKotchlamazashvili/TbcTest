package com.example.davittest.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimension(
    val none: Dp = 0.dp,
    val dimension2: Dp = 2.dp,
    val dimension4: Dp = 4.dp,
    val dimension8: Dp = 8.dp,
    val dimension16: Dp = 16.dp,
    val dimension24: Dp = 24.dp,
    val dimension32: Dp = 32.dp,
    val dimension64: Dp = 64.dp,
    val dimension128: Dp = 128.dp,
    val dimension256: Dp = 256.dp,
    )


val LocalDimension = compositionLocalOf { Dimension() }