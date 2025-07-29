package com.example.davittest.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.davittest.analytics.AnalyticsProvider
import com.example.davittest.presentation.analytics.ProfilePostHogEvents
import com.example.davittest.testing.DispatcherProvider
import com.example.davittest.testing.StandardDispatchers
import com.posthog.PostHog
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileScreenViewModel(
    private val dispatchers: DispatcherProvider = StandardDispatchers,
    private val posthogAnalyticsHelper: AnalyticsProvider,
): ViewModel() {

    private val _state = MutableStateFlow(ProfileUiState())
    val state = _state.asStateFlow()

    private val _effect = Channel<ProfileEffect>()
    val effect = _effect.receiveAsFlow()

    //anu es evventebis implementacia jobia rom private fun-ebi iyos mara aq axla
    fun onAction(action: ProfileAction){
        when(action){
            is ProfileAction.OnAccountClicked -> {
                viewModelScope.launch(dispatchers.mainImmediate) {
                    _effect.send(ProfileEffect.OnNavigateToAccount(action.id))

                }
            }
            ProfileAction.OnAddNewAccountClicked -> {
                viewModelScope.launch(dispatchers.mainImmediate) {
                    _effect.send(ProfileEffect.OnNavigateToAddNewAccount)
                }
            }
            ProfileAction.OnBackClicked -> {

                viewModelScope.launch(dispatchers.mainImmediate) {
                    _effect.send(ProfileEffect.OnNavigateBack)
                }
            }
            is ProfileAction.OnDateChanged -> {
                posthogAnalyticsHelper.trackCustomEvent(ProfilePostHogEvents.profileCalendarClicked)
                _state.update { it.copy(selectedStartDate = action.currentDate, selectedEndDate = action.endDate) }
            }
            ProfileAction.OnMoreClicked -> {
                _state.update { it.copy(showMore = !_state.value.showMore) }

                viewModelScope.launch(dispatchers.mainImmediate) {
                    _effect.send(ProfileEffect.OnError("Opananaaa"))
                }
            }
        }
    }
}