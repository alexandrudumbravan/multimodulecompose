package com.clean.presentation_navigation

private const val ROUTE_POSTS = "posts"
private const val ROUTE_POST = "posts/%s"
private const val ROUTE_USER = "users/%s"
private const val ARG_POST_ID = "postId"
private const val ARG_USER_ID = "userId"

sealed class NavRoutes(
    val route: String,
    val argumentName: String = ""
) {

    object Posts : NavRoutes(ROUTE_POSTS)

    object Post : NavRoutes(String.format(ROUTE_POST, "{$ARG_POST_ID}"), ARG_POST_ID) {

        fun routeForId(id: Long) = String.format(ROUTE_POST, id)
    }

    object User : NavRoutes(String.format(ROUTE_USER, "{$ARG_USER_ID}"), ARG_USER_ID) {

        fun routeForId(id: Long) = String.format(ROUTE_USER, id)
    }
}