package com.gyvacha.shift_test.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.gyvacha.shift_test.domain.model.navigation.AppNavigation
import com.gyvacha.shift_test.ui.screens.ProfileInfoScreen
import com.gyvacha.shift_test.ui.screens.ProfilesScreen

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navController,
        startDestination = AppNavigation.Profiles,
        modifier = modifier
    ) {
        composable<AppNavigation.Profiles> {
            ProfilesScreen(navController = navController)
        }
        composable<AppNavigation.ProfileInfo> { backstackEntry ->
            val profileId = backstackEntry.toRoute<AppNavigation.ProfileInfo>().id
            ProfileInfoScreen(navController = navController, profileId = profileId)
        }
    }
}