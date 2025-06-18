package com.artemissoftware.tridentgames.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.artemissoftware.game.presentation.GameDest
import com.artemissoftware.game.presentation.gameNavGraph
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
            navController = navHostController
        )
//        listOf(
//            GameNavGraph,
//            SearchNavGraph,
//            FavoriteNavGraph
//        ).forEach {
//            it.build(
//                modifier = Modifier.padding(top = bottomPadding).fillMaxSize(),
//                navHostController = navHostController,
//                navGraphBuilder = this
//            )
//        }
    }
}