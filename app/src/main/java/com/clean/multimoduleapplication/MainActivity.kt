package com.clean.multimoduleapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.clean.multimoduleapplication.ui.theme.MultiModuleApplicationTheme
import com.clean.presentation_navigation.NavRoutes
import com.clean.presentation_post.list.PostListScreen
import com.clean.presentation_post.single.PostScreen
import com.clean.presentation_user.single.UserScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    App(navController = navController)
                }
            }
        }
    }
}

@Composable
fun App(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.Posts.route) {
        composable(route = NavRoutes.Posts.route) {
            PostListScreen(navController, hiltViewModel())
        }
        composable(
            route = NavRoutes.Post.route,
            arguments = NavRoutes.Post.arguments
        ) {
            PostScreen(
                hiltViewModel(),
                NavRoutes.Post.fromEntry(it)
            )
        }
        composable(
            route = NavRoutes.User.route,
            arguments = NavRoutes.User.arguments
        ) {
            UserScreen(
                hiltViewModel(),
                NavRoutes.User.fromEntry(it)
            )
        }
    }
}
