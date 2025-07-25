package com.example.davittest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.davittest.design_system.preview.TbcPreview
import com.example.davittest.ui.theme.LocalDimension

data class Profile(val img: String, val name: String, val job: String)

@Composable
fun MyProfile(profile: Profile, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            contentDescription = null,
            imageVector = Icons.Default.Person,
            modifier = Modifier
                .size(LocalDimension.current.dimension64)
                .clip(
                    CircleShape
                )
        )

        Row {
            Text(text = profile.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.width(LocalDimension.current.dimension4))

            Icon(
                imageVector = Icons.Default.CheckCircle,
                tint = Color.Blue,
                contentDescription = null
            )
        }

        Text(text = profile.job, fontSize = 14.sp, color = Color.Gray)
    }
}


@Preview
@Composable
private fun MyProfilePreview() {
    TbcPreview {
        MyProfile(
            profile = Profile(
                img = "sdjkfhsdfjk",
                name = "Khatia Gogua",
                job = "Mom"
            )
        )
    }
}