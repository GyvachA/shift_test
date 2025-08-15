package com.gyvacha.shift_test.domain.model.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppNavigation : NavigationTarget {

    @Serializable
    data object Profiles : AppNavigation

    @Serializable
    data class ProfileInfo(
        val id: String
    ) : AppNavigation
}