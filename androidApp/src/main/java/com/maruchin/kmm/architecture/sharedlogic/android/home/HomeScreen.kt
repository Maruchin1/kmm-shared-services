package com.maruchin.kmm.architecture.sharedlogic.android.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maruchin.kmm.architecture.sharedlogic.android.components.LoadingView

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), onNavigateToLogin: () -> Unit) {
    LaunchedEffect(viewModel.isLoggedOut) {
        if (viewModel.isLoggedOut) onNavigateToLogin()
    }
    Scaffold(
        topBar = {
            TopAppBar(onLogout = viewModel::logout)
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(viewModel.posts, key = { it.post.id }) { post ->
                PostView(
                    title = post.post.title,
                    authorName = post.author.name,
                    body = post.post.body,
                )
            }
        }
    }
    LoadingView(viewModel.isLoading)
}

@Composable
private fun TopAppBar(onLogout: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Posts")
        },
        actions = {
            IconButton(onClick = onLogout) {
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Logout")
            }
        }
    )
}

@Composable
private fun PostView(title: String, authorName: String, body: String) {
    Column {
        Text(
            text = title,
            style = typography.h6,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = authorName,
            style = typography.caption,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
        )
        Text(
            text = body,
            style = typography.body1,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 4.dp, bottom = 16.dp)
        )
        Divider()
    }
}
