package com.maruchin.kmm.architecture.sharedlogic.android.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.kmm.architecture.sharedlogic.android.home.HOME_ROUTE

const val LOGIN_ROUTE = "login"

fun NavGraphBuilder.loginScreen(onNavigateToHome: () -> Unit) {
    composable(LOGIN_ROUTE) {
        LoginScreen(onNavigateToHome = onNavigateToHome)
    }
}

fun NavController.toLogin() {
    navigate(LOGIN_ROUTE) {
        popUpTo(HOME_ROUTE) {
            inclusive = true
        }
    }
}
