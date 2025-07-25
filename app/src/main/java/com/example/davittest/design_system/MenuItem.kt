package com.example.davittest.design_system

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.davittest.design_system.preview.TbcPreview
import com.example.davittest.ui.theme.LocalDimension

@Composable
fun MenuItem(
    iconStart: ImageVector,
    mainText: String,
    iconEnd: ImageVector? = null,
    onIconStartClick:()->Unit? = { null },
    onIconEndClick:()->Unit? = {null},
    subText: String? = null,
    iconBackgroundColor: Color = Color.Cyan.copy(alpha = 0.2f),
    iconEndColor: Color = Color.Blue,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        TbcIcon(
            icon = iconStart,
            backgroundColor = iconBackgroundColor,
            onCLick = {onIconStartClick()}
        )

        Spacer(modifier = Modifier.padding(LocalDimension.current.dimension8))

        Column(verticalArrangement = if (subText != null) Arrangement.SpaceBetween else Arrangement.Center) {

            Text(
                text = mainText, fontWeight = FontWeight.Bold, fontSize = 14.sp
            )

            subText?.let {
                Text(
                    text = it, fontSize = 12.sp, color = Color.Gray
                )
            }

        }

        Spacer(modifier = Modifier.weight(1f))

        iconEnd?.let {
            TbcIcon(
                icon = it,
                onCLick = {onIconEndClick()},
                backgroundColor = Color.Transparent,
                iconColor = iconEndColor
            )
        }
    }

}

@Preview
@Composable
private fun MenuItemPreivew() {
    TbcPreview {
        MenuItem(
            iconStart = Icons.Default.Phone,
            mainText = "Mobile Number",
            subText = "591 16 72 23",
            iconEnd = Icons.AutoMirrored.Filled.KeyboardArrowRight
        )

        MenuItem(
            iconStart = Icons.Default.Add,
            mainText = "Mobile Number",
        )
    }
}