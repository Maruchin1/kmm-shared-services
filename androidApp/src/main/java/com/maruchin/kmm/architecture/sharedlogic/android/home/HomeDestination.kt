package com.maruchin.kmm.architecture.sharedlogic.android.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(onNavigateToLogin: () -> Unit) {
    composable(HOME_ROUTE) {
        HomeScreen(onNavigateToLogin = onNavigateToLogin)
    }
}

fun NavController.toHome(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(HOME_ROUTE, builder)
}
