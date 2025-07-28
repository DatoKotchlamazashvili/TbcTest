package com.example.davittest.presentation.screen

sealed interface ProfileAction {
    data object OnBackClicked : ProfileAction
    data object OnMoreClicked : ProfileAction
    data class OnAccountClicked(val id: String) : ProfileAction

    data object OnAddNewAccountClicked: ProfileAction

    data class OnDateChanged(val currentDate:Long,val endDate: Long): ProfileAction
}
