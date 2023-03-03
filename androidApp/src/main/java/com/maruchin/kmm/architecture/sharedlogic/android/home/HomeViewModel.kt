package com.maruchin.kmm.architecture.sharedlogic.android.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.kmm.architecture.sharedlogic.android.R
import com.maruchin.kmm.architecture.sharedlogic.posts.PostsService
import com.maruchin.kmm.architecture.sharedlogic.posts.data.PostWithAuthor
import com.maruchin.kmm.architecture.sharedlogic.users.UsersService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val usersService: UsersService,
    private val postsService: PostsService,
) : ViewModel() {

    var posts by mutableStateOf<List<PostWithAuthor>>(emptyList())
    var isLoading by mutableStateOf(true)
    var isLoggedOut by mutableStateOf(false)
    var errorMessage by mutableStateOf<Int?>(null)

    init {
        loadPosts()
    }

    fun logout() = viewModelScope.launch {
        try {
            isLoading = true
            usersService.logoutUser()
            isLoading = false
            isLoggedOut = true
        } catch (e: Exception) {
            errorMessage = R.string.failed_to_logout
        }
    }

    private fun loadPosts() = viewModelScope.launch {
        try {
            isLoading = true
            posts = postsService.getPostsWithUsers()
            isLoading = false
        } catch (e: Exception) {
            errorMessage = R.string.failed_to_load_data
        }
    }
}
