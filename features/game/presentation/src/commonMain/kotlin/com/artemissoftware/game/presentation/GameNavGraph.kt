package com.artemissoftware.game.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.gameNavGraph(
    navController: NavHostController
) {

    navigation(
        route = "game",
        startDestination = GameDest.Game.route,
    ) {
        composable(route = GameDest.Game.route) {
            GameScreen(
                onFavoriteClick = {},
                onSearchClick = {},
                onClick = {},
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
