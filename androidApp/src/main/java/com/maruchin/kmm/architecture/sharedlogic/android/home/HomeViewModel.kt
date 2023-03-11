package com.maruchin.kmm.architecture.sharedlogic.android.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.kmm.sharedservices.posts.PostsService
import com.maruchin.kmm.sharedservices.posts.PostWithAuthor
import com.maruchin.kmm.sharedservices.session.SessionService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sessionService: SessionService,
    private val postsService: PostsService,
) : ViewModel() {

    var posts by mutableStateOf<List<PostWithAuthor>>(emptyList())
    var isLoading by mutableStateOf(true)
    var isLoggedOut by mutableStateOf(false)
    var error by mutableStateOf<Throwable?>(null)

    private val exceptionHandler = CoroutineExceptionHandler { _, e ->
        isLoading = false
        error = e
    }

    init {
        loadPosts()
    }

    fun logout() = viewModelScope.launch(exceptionHandler) {
        isLoading = true
        sessionService.logoutUser()
        isLoading = false
        isLoggedOut = true
    }

    private fun loadPosts() = viewModelScope.launch(exceptionHandler) {
        isLoading = true
        posts = postsService.getPostsWithAuthors()
        isLoading = false
    }
}
