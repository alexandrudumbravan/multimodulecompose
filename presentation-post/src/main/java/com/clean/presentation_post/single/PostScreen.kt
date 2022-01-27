package com.clean.presentation_post.single

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clean.presentation_common.PresentedScreen

@Composable
fun PostScreen(
    viewModel: PostViewModel,
    postId: Long
) {
    viewModel.loadPost(postId)
    viewModel.postFlow.collectAsState().value.let { result ->
        PresentedScreen(result) { postModel ->
            Post(postModel)
        }
    }
}

@Composable
fun Post(postModel: PostModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = postModel.title)
        Text(text = postModel.body)
    }
}