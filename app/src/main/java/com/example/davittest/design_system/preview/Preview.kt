package com.example.davittest.design_system.preview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.davittest.ui.theme.LocalDimension


@Composable
fun TbcPreview(modifier: Modifier = Modifier,content:@Composable ()-> Unit, ) {
    MaterialTheme {
        Surface {
            Column(modifier = modifier.fillMaxSize().padding(LocalDimension.current.dimension24), verticalArrangement = Arrangement.spacedBy(
                LocalDimension.current.dimension24
            )) {
                content()
            }
        }
    }
}