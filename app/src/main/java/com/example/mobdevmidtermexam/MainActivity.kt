package com.example.mobdevmidtermexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kotlinprac.screens.settings.SettingsScreen
import com.example.mobdevmidtermexam.screens.deliveries.DeliveriesScreen
import com.example.mobdevmidtermexam.screens.login.LoginScreen
import com.example.mobdevmidtermexam.ui.theme.MobdevMidtermExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MobdevMidtermExamTheme(
                darkTheme = true,
                dynamicColor = false
            ) {
                SettingsScreen()
            }
        }
    }
}
