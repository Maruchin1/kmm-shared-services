package com.maruchin.kmm.architecture.sharedlogic.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.kmm.architecture.sharedlogic.android.home.homeScreen
import com.maruchin.kmm.architecture.sharedlogic.android.home.toHome
import com.maruchin.kmm.architecture.sharedlogic.android.login.LOGIN_ROUTE
import com.maruchin.kmm.architecture.sharedlogic.android.login.loginScreen
import com.maruchin.kmm.architecture.sharedlogic.android.login.toLogin

@Composable
fun MainCoordinator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LOGIN_ROUTE) {
        loginScreen(
            onNavigateToHome = { navController.toHome() }
        )
        homeScreen(
            onNavigateToLogin = { navController.toLogin() }
        )
    }
}
