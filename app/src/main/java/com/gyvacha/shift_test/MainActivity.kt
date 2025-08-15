package com.gyvacha.shift_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.gyvacha.shift_test.ui.screens.MainScreen
import com.gyvacha.shift_test.ui.theme.Shift_testTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Shift_testTheme {
                AndroidShiftApp()
            }
        }
    }
}

@Composable
fun AndroidShiftApp() {
    MainScreen()
}
