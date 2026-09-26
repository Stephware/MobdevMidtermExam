package com.example.mobdevmidtermexam.screens.deliveries

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobdevmidtermexam.R
import com.example.mobdevmidtermexam.ui.theme.MobdevMidtermExamTheme

private val DeliveriesBackground = Color.Black
private val DeliveryCardBackground = Color(0xFF111111)
private val DeliveryMuted = Color(0xFFB7B7B7)
private val DeliveryBlue = Color(0xFF082B5F)
private val DeliveryOrange = Color(0xFF4A2900)

private data class DeliveryItem(
    val station: String,
    val details: String,
    val status: String,
    val statusColor: Color,
    val iconBackground: Color
)

@Composable
fun DeliveriesScreen() {
    val deliveries = listOf(
        DeliveryItem(
            station = "Station 04 - Angeles",
            details = "1,200L diesel • en route",
            status = "on time",
            statusColor = Color(0xFF4CAF50),
            iconBackground = DeliveryBlue
        ),
        DeliveryItem(
            station = "Station 11 - Mabalacat",
            details = "800L gasoline • pending",
            status = "delayed",
            statusColor = Color(0xFFFF9800),
            iconBackground = DeliveryOrange
        ),
        DeliveryItem(
            station = "Station 02 - San Fernando",
            details = "1,500L diesel • scheduled",
            status = "queued",
            statusColor = Color.LightGray,
            iconBackground = DeliveryBlue
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeliveriesBackground)
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Deliveries",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Box(
                modifier = Modifier
                    .size(28.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF6F6F6F),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Bell Icon",
                    tint = Color.White,
                    modifier = Modifier.size(50.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))
        HorizontalDivider(color = Color(0xFF2E2E2E))
        Spacer(modifier = Modifier.height(24.dp))

        deliveries.forEachIndexed { index, delivery ->
            DeliveryCard(delivery)

            if (index != deliveries.lastIndex) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun DeliveryCard(delivery: DeliveryItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = DeliveryCardBackground
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(14.dp),
                color = delivery.iconBackground
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.fuel),
                    contentDescription = "Fuel Icon",
                    tint = Color.White,
                    modifier = Modifier.size(50.dp)
                )
                Box(
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(18.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = delivery.station,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = delivery.details,
                    color = DeliveryMuted,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = delivery.statusColor.copy(alpha = 0.15f)
            ) {
                Text(
                    text = delivery.status,
                    color = delivery.statusColor,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 6.dp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DeliveriesScreenPreview() {
    MobdevMidtermExamTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        DeliveriesScreen()
    }
}
