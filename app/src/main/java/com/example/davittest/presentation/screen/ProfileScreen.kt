package com.example.davittest.presentation.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.davittest.design_system.MenuItem
import com.example.davittest.design_system.ScreenHeader
import com.example.davittest.design_system.calendar.TbcCalendar
import com.example.davittest.design_system.preview.TbcPreview
import com.example.davittest.design_system.transfer_history.TbcTransferHistory
import com.example.davittest.design_system.transfer_info.TbcTransferInfo
import com.example.davittest.design_system.transfer_info.TransferInfo
import com.example.davittest.presentation.components.MyProfile
import com.example.davittest.presentation.components.Profile
import com.example.davittest.presentation.extension.CollectAsUiEvents
import com.example.davittest.ui.theme.LocalDimension
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlin.contracts.Effect
import kotlin.random.Random


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfileScreen(viewModel: ProfileScreenViewModel,snackbarHostState: SnackbarHostState,modifier: Modifier = Modifier) {

    val uiState  = viewModel.state.collectAsStateWithLifecycle()

    Log.d("uiState",uiState.toString())

    ProfileScreenContent(
        uiState = uiState.value,
        onAction = viewModel::onAction,
        modifier = modifier,
        effects = viewModel.effect,
        onNavigateBack = {  },
        onNavigateToAccount = {  },
        onNavigateToAddNewAccount = {  },
        snackbarHostState = snackbarHostState,
    )
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfileScreenContent(
    uiState: ProfileUiState,
    onAction: (ProfileAction) -> Unit,
    effects: Flow<ProfileEffect>,
    onNavigateBack:()->Unit,
    onNavigateToAccount:(String)->Unit,
    onNavigateToAddNewAccount:()-> Unit,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {


    effects.CollectAsUiEvents{ effect ->
        when(effect){
            is ProfileEffect.OnError -> snackbarHostState.showSnackbar(effect.message)
            ProfileEffect.OnNavigateBack -> {
                onNavigateBack()
            }
            is ProfileEffect.OnNavigateToAccount -> {
                onNavigateToAccount(effect.id)
            }
            ProfileEffect.OnNavigateToAddNewAccount -> {
                onNavigateToAddNewAccount()
            }
        }
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(LocalDimension.current.dimension8),
    ) {
        item {
            ScreenHeader(
                onBackClick = { onAction(ProfileAction.OnBackClicked) },
                onMoreClick = { onAction(ProfileAction.OnMoreClicked) }
            )
            Spacer(modifier = Modifier.height(LocalDimension.current.dimension32))

            MyProfile(profile = uiState.profile)

            Spacer(modifier = Modifier.height(LocalDimension.current.dimension16))
            Text(text = "Account", color = Color.Black, fontWeight = FontWeight.Black)
        }

        items(uiState.accounts) { account ->
            MenuItem(
                iconStart = account.iconStart,
                mainText = account.mainText,
                subText = account.subText,
                iconEnd = account.iconEnd,
                iconEndColor = Color.Cyan,
                onIconEndClick = { onAction(ProfileAction.OnAccountClicked(account.id)) }
            )
        }

        item {
            MenuItem(
                iconStart = Icons.Default.Add,
                mainText = "Add new Account",
                onIconStartClick = { onAction(ProfileAction.OnAddNewAccountClicked) }
            )

            Spacer(modifier = Modifier.height(LocalDimension.current.dimension32))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Preview Transfers", color = Color.Black, fontWeight = FontWeight.Black)

                Spacer(modifier = Modifier.weight(1f))

                TbcCalendar(
                    currentStart = uiState.selectedStartDate,
                    currentEnd = uiState.selectedEndDate,
                ){startDate,endDate->
                    onAction(ProfileAction.OnDateChanged(startDate,endDate))
                }
            }

            Spacer(modifier = Modifier.height(LocalDimension.current.dimension8))

            Row {
                TbcTransferInfo(
                    transferInfo = TransferInfo.RECEIVE,
                    amount = 13375.0,
                    modifier = Modifier.weight(0.4f)
                )
                Spacer(modifier = Modifier.weight(0.1f))
                TbcTransferInfo(
                    transferInfo = TransferInfo.SENT,
                    amount = 13375.0,
                    modifier = Modifier.weight(0.4f)
                )
            }
           Spacer(modifier = Modifier.height(LocalDimension.current.dimension24))
        }



        items(uiState.transactions) { transaction ->
            TbcTransferHistory(
                date = transaction.date,
                title = transaction.title,
                transferHistory = transaction.transferHistory,
                icon = transaction.icon,
                backGroundColor = Color(Random.nextInt())
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ProfileScreenContentPreivew() {
    TbcPreview {
        ProfileScreenContent(
            uiState = ProfileUiState(),
            onAction = { },
            effects = flowOf(),
            onNavigateBack = {  },
            onNavigateToAccount = {  },
            onNavigateToAddNewAccount = {  },
            snackbarHostState = SnackbarHostState(),
        )
    }
}