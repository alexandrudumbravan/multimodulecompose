package com.clean.presentation_user.single

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clean.presentation_common.PresentedScreen

@Composable
fun UserScreen(
    viewModel: UserViewModel,
    userId: Long
) {
    viewModel.loadUser(userId)
    viewModel.userFlow.collectAsState().value.let { result ->
        PresentedScreen(result) { userModel ->
            User(userModel)
        }
    }
}

@Composable
fun User(userModel: UserModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = userModel.name)
        Text(text = userModel.username)
        Text(text = userModel.email)
    }
}