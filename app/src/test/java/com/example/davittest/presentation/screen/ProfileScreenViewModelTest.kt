package com.example.davittest.presentation.screen

import com.example.davittest.TestDispatchers
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProfileScreenViewModelTest {

    private lateinit var viewModel: ProfileScreenViewModel
    private lateinit var testDispatchers: TestDispatchers

    @Before
    fun setUp() {
        testDispatchers = TestDispatchers()
        viewModel = ProfileScreenViewModel(
            dispatchers = testDispatchers
        )
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when onMoreClicked it updates state accordingly`() = runTest(testDispatchers.testDispatcher) {
        assertThat(viewModel.state.value.showMore).isFalse()

        viewModel.onAction(ProfileAction.OnMoreClicked)

        runCurrent()
        assertThat(viewModel.state.value.showMore).isTrue()

        viewModel.onAction(ProfileAction.OnMoreClicked)
        runCurrent()
        assertThat(viewModel.state.value.showMore).isFalse()

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when OnDateChanged it updates state accordingly`() = runTest(testDispatchers.testDispatcher) {

        viewModel.onAction(ProfileAction.OnDateChanged(0L,0L))

        runCurrent()
        assertThat(viewModel.state.value.selectedEndDate).isEqualTo(0L)
        assertThat(viewModel.state.value.selectedStartDate).isEqualTo(0L)


    }


    //this was suggested by main man
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when OnBackCLicked it emits according event`() = runTest(testDispatchers.testDispatcher) {

        val effects = mutableListOf<ProfileEffect>()
        val job = launch {
            viewModel.effect.take(1)

                .toList(effects)
        }

        viewModel.onAction(ProfileAction.OnBackClicked)
        runCurrent()

        assertThat(effects).containsExactly(ProfileEffect.OnNavigateBack)
        job.cancel()

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when OnAddNewAccountClicked it emits according event`() = runTest(testDispatchers.testDispatcher) {

        val effects = mutableListOf<ProfileEffect>()
        val job = launch {
            viewModel.effect.take(1)

                .toList(effects)
        }

        viewModel.onAction(ProfileAction.OnAddNewAccountClicked)
        runCurrent()

        assertThat(effects).containsExactly(ProfileEffect.OnNavigateToAddNewAccount)
        job.cancel()

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when OnAccountClicked it emits according event`() = runTest(testDispatchers.testDispatcher) {

        val profileId = "dato mxecia"

        val effects = mutableListOf<ProfileEffect>()
        val job = launch {
            viewModel.effect.take(1)

                .toList(effects)
        }

        viewModel.onAction(ProfileAction.OnAccountClicked(profileId))
        runCurrent()

        assertThat(effects).containsExactly(ProfileEffect.OnNavigateToAccount(profileId))
        job.cancel()

    }


}