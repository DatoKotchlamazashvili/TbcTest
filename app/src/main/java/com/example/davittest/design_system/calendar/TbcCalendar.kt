package com.example.davittest.design_system.calendar


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.davittest.design_system.preview.TbcPreview
import com.example.davittest.ui.theme.LocalDimension
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TbcCalendar(
    currentStart: Long,
    currentEnd: Long,
    onDateChanged: (Long, Long) -> Unit,
) {
    var showDialog by remember { mutableStateOf(false) }

    val formatter by remember {
        mutableStateOf(
            DateTimeFormatter.ofPattern("dd.MM.yy")
        )
    }

    val dateRangePickerState = remember {
        DateRangePickerState(
            initialSelectedStartDateMillis = currentStart,
            initialSelectedEndDateMillis = currentEnd,
            locale = CalendarLocale.SIMPLIFIED_CHINESE
        )
    }

    LaunchedEffect(
        dateRangePickerState.selectedStartDateMillis,
        dateRangePickerState.selectedEndDateMillis
    ) {
        val start = dateRangePickerState.selectedStartDateMillis
        val end = dateRangePickerState.selectedEndDateMillis
        if (start != null && end != null) {
            showDialog = false
            onDateChanged(start, end)
        }
    }

    Row(modifier = Modifier.clickable(onClick = { showDialog = !showDialog })) {

        Icon(
            imageVector = Icons.Default.DateRange,
            tint = Color.Cyan,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(LocalDimension.current.dimension8))


        Text("${formatter.format(millisToLocalDate(currentStart))}-${formatter.format(millisToLocalDate(currentEnd))}")


        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
            DateRangePicker(modifier = Modifier.fillMaxSize(),
                state = dateRangePickerState,
            )
        }}
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun TbcCalendarPreview() {
    TbcPreview {
        TbcCalendar (
            currentStart = 0L,
            currentEnd = 0L
        ) { newStart, newEnd ->

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun millisToLocalDate(millis: Long): LocalDate =
    Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate()
