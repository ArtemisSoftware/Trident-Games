@file:OptIn(ExperimentalMaterial3Api::class)

package com.artemissoftware.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.artemissoftware.domain.models.Game
import com.artemissoftware.favorite.composables.GameItem
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun FavoriteScreen(
    onBackClick: () -> Unit,
    onDetails: (Int) -> Unit,
    viewModel: FavoriteViewModel = koinViewModel<FavoriteViewModel>()
) {

    val games = viewModel.games.collectAsStateWithLifecycle().value

    FavoriteContent(
        games = games,
        onBackClick = onBackClick,
        onDetails = onDetails,
        onDelete = {
            viewModel.delete(it)
        }
    )

}

@Composable
private fun FavoriteContent(
    games: List<Game>,
    onBackClick: () -> Unit,
    onDetails: (Int) -> Unit,
    onDelete: (Int) -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Favorites")
                }, navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable { onBackClick() }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        if (games.isEmpty()) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Nothing found")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(games) { item ->
                    GameItem(
                        isDeleteShown = true,
                        item = item,
                        onClick = onDetails,
                        onDeleteClick = onDelete
                    )
                }
            }
        }
    }
}