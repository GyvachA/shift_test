package com.gyvacha.shift_test.ui.screens

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gyvacha.shift_test.ui.navigation.AppNavGraph
import com.gyvacha.shift_test.ui.utils.LocalMessageNotifier
import com.gyvacha.shift_test.ui.utils.SnackBarNotifier

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val snackBarNotifier = remember { SnackBarNotifier(snackBarHostState, coroutineScope) }
    CompositionLocalProvider(LocalMessageNotifier provides snackBarNotifier) {
        Scaffold(
            contentWindowInsets = WindowInsets.safeDrawing,
            snackbarHost = { SnackbarHost(snackBarHostState) }
        ) { innerPadding ->
            AppNavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
        }
    }
}