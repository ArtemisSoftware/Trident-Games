package com.artemissoftware.game.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.artemissoftware.game.presentation.details.DetailsScreen
import com.artemissoftware.game.presentation.game.GameScreen

fun NavGraphBuilder.gameNavGraph(
    navController: NavHostController,
    onSearchClick:()->Unit,
) {

    navigation(
        route = "game",
        startDestination = GameDest.Game.route,
    ) {
        composable(route = GameDest.Game.route) {
            GameScreen(
                onFavoriteClick = {},
                onSearchClick = onSearchClick,
                onClick = {
                    navController.navigate(GameDest.Details.getRoute(it))
                },
            )
        }

        composable(route = GameDest.Details.route) {

            val id = it.arguments?.getString("id")

            DetailsScreen(
                id = id.toString(),
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }
}

sealed class GameDest(val route: String) {

    data object Game : GameDest("/game")

    data object Details : GameDest("/game_details/{id}") {
        fun getRoute(id: Int) = "/game_details/${id}"
    }

}
