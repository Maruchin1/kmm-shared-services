package com.maruchin.kmm.architecture.sharedlogic.android.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.kmm.sharedservices.session.SessionService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val DEMO_USER_EMAIL = "Sincere@april.biz"

@HiltViewModel
class LoginViewModel @Inject constructor(private val sessionService: SessionService) : ViewModel() {

    var email by mutableStateOf(DEMO_USER_EMAIL)
    var isLoading by mutableStateOf(false)
    var isLoggedIn by mutableStateOf(false)
    var error by mutableStateOf<Throwable?>(null)

    private val exceptionHandler = CoroutineExceptionHandler { _, e ->
        isLoading = false
        error = e
    }

    fun login() = viewModelScope.launch(exceptionHandler) {
        isLoading = true
        sessionService.loginUser(email)
        isLoading = false
        isLoggedIn = true
    }
}
