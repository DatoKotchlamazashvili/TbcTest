package com.example.davittest.design_system

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.davittest.design_system.preview.TbcPreview
import com.example.davittest.ui.theme.LocalDimension


@Composable
fun TbcIcon(
    icon: ImageVector,
    iconColor: Color = Color.Blue,
    backgroundColor: Color = Color.Cyan,
    onCLick: () -> Unit? = { null },
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .size(width = 56.dp, height = 48.dp)
            .clickable(
                onClick = { onCLick.invoke() }
            )
            .clip(shape = RoundedCornerShape(LocalDimension.current.dimension8))
            .background(color = backgroundColor)
            ,
        contentAlignment = Alignment.Center) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(LocalDimension.current.dimension32),
            tint = iconColor
        )

    }
}

@Preview
@Composable
private fun TbcIconPreivew() {
    TbcPreview {
        TbcIcon(
            icon = Icons.Default.Add,
            onCLick = {  },
        )
    }
}