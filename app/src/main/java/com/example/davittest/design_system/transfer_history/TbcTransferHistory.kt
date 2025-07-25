package com.example.davittest.design_system.transfer_history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.davittest.design_system.preview.TbcPreview
import com.example.davittest.design_system.transfer_history.TransferHistory.Companion.fromMoney
import com.example.davittest.ui.theme.LocalDimension


@Composable
fun TbcTransferHistory(
    date: String,
    title: String,
    transferHistory: TransferHistory,
    icon: ImageVector,
    backGroundColor: Color = Color.Magenta,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = date
        )

        Spacer(modifier = Modifier.height(LocalDimension.current.dimension4))

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(backGroundColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = icon, contentDescription = null, tint = Color.White)
            }
            Spacer(modifier = Modifier.width(LocalDimension.current.dimension8))

            Text(
                text = title, fontSize = 18.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(text = transferHistory.geText(), color = transferHistory.getColor())
        }
    }
}

@Preview
@Composable
private fun TbcTransferHistoryPreivew() {
    TbcPreview {
        TbcTransferHistory(
            date = "8 May, 2025",
            title = "Private Transfer",
            transferHistory = (211.0).fromMoney(),
            icon = Icons.Default.MoreVert
        )

        TbcTransferHistory(
            date = "8 May, 2025",
            title = "Private Transfer",
            transferHistory = (-211.0).fromMoney(),
            icon = Icons.Default.ShoppingCart
        )

        TbcTransferHistory(
            date = "8 May, 2025",
            title = "Private Transfer",
            transferHistory = (0.0).fromMoney(),
            icon = Icons.Default.Build
        )
    }
}