package com.example.davittest.presentation.extension



fun Double.asCurrencyFormat(curreny: String = "₾"): String{
    return when{
        this == 0.0 -> "0.0"
        this >0.0 -> "$this $curreny"
        else -> "-$this $curreny"
    }
}