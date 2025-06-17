package com.artemissoftware.tridentgames.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun RootNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = "GameNavGraph.Dest.Root.route"
    ) {
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