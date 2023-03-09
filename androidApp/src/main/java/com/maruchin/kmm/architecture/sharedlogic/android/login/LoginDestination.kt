package com.maruchin.kmm.architecture.sharedlogic.android.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable

const val LOGIN_ROUTE = "login"

fun NavGraphBuilder.loginScreen(onNavigateToHome: () -> Unit) {
    composable(LOGIN_ROUTE) {
        LoginScreen(onNavigateToHome = onNavigateToHome)
    }
}

fun NavController.toLogin(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(LOGIN_ROUTE, builder)
}
