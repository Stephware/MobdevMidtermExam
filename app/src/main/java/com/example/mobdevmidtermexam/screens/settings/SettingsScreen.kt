package com.example.mobdevmidtermexam.screens.settings

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobdevmidtermexam.R
import com.example.mobdevmidtermexam.ui.theme.MobdevMidtermExamTheme

private val SettingsBackground = Color.Black
private val SettingsCard = Color(0xFF111111)
private val SettingsMuted = Color(0xFF8D8D8D)
private val DividerColor = Color(0xFF303030)
private val SettingsBlue = Color(0xFF4C82D9)

@Composable
fun SettingsScreen() {
    var deliveryAlerts by remember { mutableStateOf(true) }
    var delayWarnings by remember { mutableStateOf(true) }
    var weeklySummary by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SettingsBackground)
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Settings",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(18.dp))
        HorizontalDivider(color = DividerColor)
        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "NOTIFICATIONS",
            color = SettingsMuted,
            style = MaterialTheme.typography.labelLarge
        )

        Spacer(modifier = Modifier.height(14.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = SettingsCard)
        ) {
            SettingSwitchRow(
                label = "Delivery alerts",
                checked = deliveryAlerts,
                onCheckedChange = { deliveryAlerts = it }
            )
            HorizontalDivider(color = DividerColor)
            SettingSwitchRow(
                label = "Delay warnings",
                checked = delayWarnings,
                onCheckedChange = { delayWarnings = it }
            )
            HorizontalDivider(color = DividerColor)
            SettingSwitchRow(
                label = "Weekly summary",
                checked = weeklySummary,
                onCheckedChange = { weeklySummary = it }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "ACCOUNT",
            color = SettingsMuted,
            style = MaterialTheme.typography.labelLarge
        )

        Spacer(modifier = Modifier.height(14.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = SettingsCard)
        ) {
            AccountRow(
                label = "Edit profile",
                iconRes = R.drawable.profile
            )
            HorizontalDivider(color = DividerColor)
            AccountRow(
                label = "Change password",
                iconRes = R.drawable.password
            )
            HorizontalDivider(color = DividerColor)
            AccountRow(
                label = "Log out",
                iconRes = R.drawable.logout,
                textColor = Color(0xFFE57373),
                showArrow = false
            )
        }
    }
}

@Composable
private fun SettingSwitchRow(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.weight(1f))

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = SettingsBlue,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = Color(0xFF4A4A4A)
            )
        )
    }
}

@Composable
private fun AccountRow(
    label: String,
    @DrawableRes iconRes: Int,
    textColor: Color = Color.White,
    showArrow: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            tint = textColor,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = label,
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.weight(1f))

        if (showArrow) {
            Text(
                text = "›",
                color = SettingsMuted,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    MobdevMidtermExamTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        SettingsScreen()
    }
}
