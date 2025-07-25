package com.example.davittest.design_system.transfer_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.davittest.design_system.TbcIcon
import com.example.davittest.design_system.preview.TbcPreview
import com.example.davittest.presentation.extension.asCurrencyFormat
import com.example.davittest.ui.theme.LocalDimension


@Composable
fun TbcTransferInfo(transferInfo: TransferInfo, amount: Double, modifier: Modifier = Modifier) {

    val content = LocalContext.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(LocalDimension.current.dimension4))
            .background(color = Color.Gray.copy(alpha = 0.1f))
            .padding(LocalDimension.current.dimension4)
    ) {
        TbcIcon(
            icon = transferInfo.getIcon(),
            iconColor = transferInfo.getColor(),
            backgroundColor = Color.Transparent
        )
        Column {
            Text(text = content.getString(transferInfo.getTextResourceId()), color = Color.DarkGray)

            Text(
                text = amount.asCurrencyFormat(),
                color = transferInfo.getColor()
            )
        }
    }
}

@Preview
@Composable
private fun TbcTransferInfoPreview() {
    TbcPreview {

        Row {
            TbcTransferInfo(transferInfo = TransferInfo.RECEIVE,
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
    }
}