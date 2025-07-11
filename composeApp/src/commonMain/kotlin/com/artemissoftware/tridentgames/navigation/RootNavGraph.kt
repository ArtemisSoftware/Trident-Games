package com.artemissoftware.tridentgames.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.artemissoftware.game.presentation.navigation.GameDest
import com.artemissoftware.game.presentation.navigation.gameNavGraph
import com.artemissoftware.navigation.FavoriteDest
import com.artemissoftware.navigation.favoriteNavGraph
import com.artemissoftware.search.presentation.navigation.SearchDest
import com.artemissoftware.search.presentation.navigation.searchNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun RootNavGraph(
    navHostController: NavHostController,
    startDestination: Any = GameDest.Game.route,
) {
    NavHost(
        navController = navHostController,
        startDestination = "game"
    ) {

        gameNavGraph(
            navController = navHostController,
            onSearchClick = {
                navHostController.navigate(SearchDest.Search.route)
            },
            navigateToFavorite = {
                navHostController.navigate(FavoriteDest.Favorite.route)
            }
        )

        searchNavGraph(
            navController = navHostController,
            navigateToDetail = {
                navHostController.navigate(GameDest.Details.getRoute(it))
            }
        )

        favoriteNavGraph(
            navController = navHostController,
            navigateToDetails = {
                navHostController.navigate(GameDest.Details.getRoute(it))
            }
        )
    }
}