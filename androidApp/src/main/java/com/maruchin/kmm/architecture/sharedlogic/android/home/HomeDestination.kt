package com.maruchin.kmm.architecture.sharedlogic.android.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.kmm.architecture.sharedlogic.android.login.LOGIN_ROUTE

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(onNavigateToLogin: () -> Unit) {
    composable(HOME_ROUTE) {
        HomeScreen(onNavigateToLogin = onNavigateToLogin,)
    }
}

fun NavController.toHome() {
    navigate(HOME_ROUTE) {
        popUpTo(LOGIN_ROUTE) {
            inclusive = true
        }
    }
}
