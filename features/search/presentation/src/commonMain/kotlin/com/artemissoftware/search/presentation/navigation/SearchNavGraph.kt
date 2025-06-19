package com.artemissoftware.search.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.artemissoftware.search.presentation.SearchScreen

fun NavGraphBuilder.searchNavGraph(
    navController: NavHostController
) {

    navigation(
        route = "search",
        startDestination = SearchDest.Search.route,
    ) {
        composable(route = SearchDest.Search.route) {
            SearchScreen(
                onBackClick = { navController.popBackStack() },
                onClick = {},
            )
        }

    }
}

sealed class SearchDest(val route: String) {

    data object Search : SearchDest("/search")
}
