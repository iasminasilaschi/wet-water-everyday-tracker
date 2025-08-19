package com.iasmi.wet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun WaterCounterScreen(modifier: Modifier) {
    // Dependency Injection Pattern: Get context from Compose
    val context = LocalContext.current
    val waterPrefs = remember { WaterPreferences(context) }

    // Single Responsibility Principle: This screen only handles water counting
    // State management: UI state + persistent storage
    var waterCount by remember { mutableIntStateOf(0) }  // State hoisting pattern

    // LaunchedEffect: Run once when screen loads (like onCreate)
    LaunchedEffect(Unit) {
        waterCount = waterPrefs.getTodaysWaterCount()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$waterCount glasses \uD83D\uDCA7",
            style = MaterialTheme.typography.headlineLarge
        )

        Button(
            onClick = {
                waterCount++
                waterPrefs.saveWaterCount(waterCount) // Save immediately
            }
        ) {
            Text("Drink Water! 💧")
        }
    }
}