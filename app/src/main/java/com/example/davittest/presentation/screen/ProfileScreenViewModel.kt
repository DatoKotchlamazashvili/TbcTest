package com.example.davittest.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileScreenViewModel: ViewModel() {

    private val _state = MutableStateFlow<ProfileUiState>(ProfileUiState())
    val state = _state.asStateFlow()

    private val _effect = Channel<ProfileEffect>()
    val effect = _effect.receiveAsFlow()


    fun onAction(action: ProfileAction){
        when(action){
            is ProfileAction.OnAccountClicked -> {
                viewModelScope.launch {
                    _effect.send(ProfileEffect.OnNavigateToAccount(action.id))

                }
            }
            ProfileAction.OnAddNewAccountClicked -> {
                viewModelScope.launch {
                    _effect.send(ProfileEffect.OnNavigateToAddNewAccount)
                }
            }
            ProfileAction.OnBackClicked -> {

                viewModelScope.launch {
                    _effect.send(ProfileEffect.OnNavigateBack)
                }
            }
            is ProfileAction.OnDateChanged -> {
                _state.update { it.copy(selectedStartDate = action.currentDate, selectedEndDate = action.endDate) }
            }
            ProfileAction.OnMoreClicked -> {
                _state.update { it.copy(showMore = !_state.value.showMore) }

                viewModelScope.launch {
                    _effect.send(ProfileEffect.OnError("Opananaaa"))
                }
            }
        }
    }
}