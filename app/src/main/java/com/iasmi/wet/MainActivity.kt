package com.iasmi.wet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.iasmi.wet.ui.theme.WetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WetTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {}
                ) { innerPadding ->
                    WaterCounterScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
