package com.example.davittest.design_system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.davittest.design_system.preview.TbcPreview


@Composable
fun ScreenHeader(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.Cyan,
            modifier = Modifier.clickable(onClick = { onBackClick() })
        )

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null, tint = Color.Cyan,
            modifier = Modifier.clickable(onClick = {onMoreClick()})
        )

    }
}

@Preview
@Composable
private fun ScreenHeaderPreview() {
    TbcPreview {
        ScreenHeader(
            onBackClick = {  },
            onMoreClick = {  }
        )
    }
}