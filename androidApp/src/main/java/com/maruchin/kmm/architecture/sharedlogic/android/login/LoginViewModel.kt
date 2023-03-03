package com.maruchin.kmm.architecture.sharedlogic.android.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.kmm.architecture.sharedlogic.android.R
import com.maruchin.kmm.sharedservices.users.UsersService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val DEMO_USER_EMAIL = "Sincere@april.biz"

@HiltViewModel
class LoginViewModel @Inject constructor(private val usersService: UsersService) : ViewModel() {

    var email by mutableStateOf(DEMO_USER_EMAIL)
    var isLoading by mutableStateOf(false)
    var isLoggedIn by mutableStateOf(false)
    var errorMessage by mutableStateOf<Int?>(null)

    fun login() = viewModelScope.launch {
        try {
            isLoading = true
            usersService.loginUser(email)
            isLoading = false
            isLoggedIn = true
        } catch (e: Exception) {
            errorMessage = R.string.failed_to_login
        }
    }
}
