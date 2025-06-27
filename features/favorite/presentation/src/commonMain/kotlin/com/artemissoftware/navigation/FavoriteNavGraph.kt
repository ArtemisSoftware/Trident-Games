package com.artemissoftware.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.artemissoftware.favorite.FavoriteScreen

fun NavGraphBuilder.favoriteNavGraph(
    navController: NavHostController,
    navigateToDetails: (Int) -> Unit,
) {

    navigation(
        route = "favorite",
        startDestination = FavoriteDest.Favorite.route,
    ) {
        composable(route = FavoriteDest.Favorite.route) {
            FavoriteScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onDetails = navigateToDetails,
            )
        }
    }
}

sealed class FavoriteDest(val route: String) {
    data object Favorite : FavoriteDest("/favorite")
}